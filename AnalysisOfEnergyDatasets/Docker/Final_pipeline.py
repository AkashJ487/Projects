
# coding: utf-8

# # Final pipeline

# Importing Libraries

# In[9]:


import pandas as pd
import datetime
import numpy as np
import sklearn
from sklearn.cross_validation import train_test_split 
from sklearn.ensemble import RandomForestRegressor
from sklearn.preprocessing import StandardScaler
from sklearn.metrics import *
from sklearn.pipeline import Pipeline


# List of Customised functions used

# In[10]:


def mean_absolute_percentage_error(y_true, y_pred): 
        y_true, y_pred = np.array(y_true), np.array(y_pred)
        return np.mean(np.abs((y_true - y_pred) / y_true)) * 100
weekend = ['Saturday','Sunday']
def week_day_type(x):
    if x in weekend:
        return 'weekends'
    else:
        return 'weekdays'
morning=range(6,12)
afternoon=range(12,17)
evening=range(17,22)
def time_slot(x):
    if x in morning:
        return 'morning'
    elif x in afternoon:
        return 'afternoon'
    elif x in evening:
        return 'evening'
    else:
        return 'night'  


# Reading the csv file and loading it into a dataframe

# In[11]:


df=pd.read_csv("energydata_complete.csv")

# Creating additional features and dummy columns in the data so that our models get more insights and make more accurate predictions

# In[12]:


df['date']=pd.to_datetime(df['date'])
df['year']=df['date'].dt.year
df['month']=df['date'].dt.month
df['day']=df['date'].dt.day
df['day_of_week']=df['date'].dt.weekday_name
df['time_hr_24']=df['date'].dt.hour
df['time_min']=df['date'].dt.minute
df['week_day_type']=df['day_of_week'].map(week_day_type)
morning=range(6,12)
afternoon=range(12,17)
evening=range(17,22)  
df['time_slot']=df['time_hr_24'].map(time_slot)
df.drop(['date'],axis=1,inplace=True)
df=pd.get_dummies(df,prefix=['DOW','TS','WDT'],columns=['day_of_week','time_slot','week_day_type'])


# Removing outliers

# In[13]:


df=df[(df['Appliances']-df['Appliances'].mean()).abs() <= 3*df['Appliances'].std()]
df=df[(df['lights']-df['lights'].mean()).abs() <= 3*df['lights'].std()]
df=df[(df['T1']-df['T1'].mean()).abs() <= 3*df['T1'].std()]
df=df[(df['T2']-df['T2'].mean()).abs() <= 3*df['T2'].std()]
df=df[(df['T3']-df['T3'].mean()).abs() <= 3*df['T3'].std()]
df=df[(df['T4']-df['T4'].mean()).abs() <= 3*df['T4'].std()]
df=df[(df['T5']-df['T5'].mean()).abs() <= 3*df['T5'].std()]
df=df[(df['T6']-df['T6'].mean()).abs() <= 3*df['T6'].std()]
df=df[(df['T7']-df['T7'].mean()).abs() <= 3*df['T7'].std()]
df=df[(df['T8']-df['T8'].mean()).abs() <= 3*df['T8'].std()]
df=df[(df['T9']-df['T9'].mean()).abs() <= 3*df['T9'].std()]
df=df[(df['T_out']-df['T_out'].mean()).abs() <= 3*df['T_out'].std()]
df=df[(df['RH_1']-df['RH_1'].mean()).abs() <= 3*df['RH_1'].std()]
df=df[(df['RH_2']-df['RH_2'].mean()).abs() <= 3*df['RH_2'].std()]
df=df[(df['RH_3']-df['RH_3'].mean()).abs() <= 3*df['RH_3'].std()]
df=df[(df['RH_4']-df['RH_4'].mean()).abs() <= 3*df['RH_4'].std()]
df=df[(df['RH_5']-df['RH_5'].mean()).abs() <= 3*df['RH_5'].std()]
df=df[(df['RH_6']-df['RH_6'].mean()).abs() <= 3*df['RH_6'].std()]
df=df[(df['RH_7']-df['RH_7'].mean()).abs() <= 3*df['RH_7'].std()]
df=df[(df['RH_8']-df['RH_8'].mean()).abs() <= 3*df['RH_8'].std()]
df=df[(df['RH_9']-df['RH_9'].mean()).abs() <= 3*df['RH_9'].std()]
df=df[(df['RH_out']-df['RH_out'].mean()).abs() <= 3*df['RH_out'].std()]
df=df[(df['Press_mm_hg']-df['Press_mm_hg'].mean()).abs() <= 3*df['Press_mm_hg'].std()]
df=df[(df['Windspeed']-df['Windspeed'].mean()).abs() <= 3*df['Windspeed'].std()]
df=df[(df['Visibility']-df['Visibility'].mean()).abs() <= 3*df['Visibility'].std()]
df=df[(df['Tdewpoint']-df['Tdewpoint'].mean()).abs() <= 3*df['Tdewpoint'].std()]
df=df[(df['rv1']-df['rv1'].mean()).abs() <= 3*df['rv1'].std()]
df=df[(df['rv2']-df['rv2'].mean()).abs() <= 3*df['rv2'].std()]


# Spliting data and normalization and selecting the best features that we got from boruta in Part 5

# In[15]:


df_train,df_test = train_test_split(df,train_size=0.7,random_state=42)
scaler = StandardScaler()
column_list = ['lights', 'RH_1', 'T2', 'RH_2', 'T3', 'RH_3', 'T4', 'RH_4', 'T5',
       'RH_5', 'T6', 'RH_7', 'T8', 'RH_8', 'T9', 'RH_9', 'Press_mm_hg',
       'RH_out', 'time_hr_24', 'TS_night']
x_train=df_train.iloc[:,1:]
x_train= x_train[column_list]
print("Training :",x_train.shape)
y_train=df_train['Appliances']
scaler.fit(x_train)
x_train_sc=scaler.transform(x_train)
x_test=df_test.iloc[:,1:]
x_test = x_test[column_list]
print("Testing :",x_test.shape)
y_test=df_test['Appliances']
scaler.fit(x_test)
x_test_sc=scaler.transform(x_test)


# Using the Random Forset model with hyperparameters that we got from boruta

# In[16]:


pipe = Pipeline([('gfdh',RandomForestRegressor(bootstrap=True, criterion='mse', max_depth=25,
           max_features='auto', max_leaf_nodes=None,
           min_impurity_decrease=0.0, min_impurity_split=None,
           min_samples_leaf=1, min_samples_split=2,
           min_weight_fraction_leaf=0.0, n_estimators=25, n_jobs=1,
           oob_score=False,
           random_state=42,
           verbose=0, warm_start=False))])
pipe.fit(x_train, y_train)


# Finding R2, MAE , RMSE and MAPE on training data

# In[17]:

print("For Training dataset")
y_train_pred=pipe.predict(x_train)
print("R2   :",r2_score(y_train,y_train_pred))
print("MAE  :",mean_absolute_error(y_train,y_train_pred))
print("RMSE :",np.sqrt(mean_squared_error(y_train,y_train_pred)))
print("MAPE :",mean_absolute_percentage_error(y_train,y_train_pred))


# Finding R2, MAE , RMSE and MAPE on testing data

# In[18]:

print("For Testing dataset")
y_test_pred=pipe.predict(x_test)
print("R2   :",r2_score(y_test,y_test_pred))
print("MAE  :",mean_absolute_error(y_test,y_test_pred))
print("RMSE :",np.sqrt(mean_squared_error(y_test,y_test_pred)))
print("MAPE :",mean_absolute_percentage_error(y_test,y_test_pred))


# Finding the accyracy of testing.
