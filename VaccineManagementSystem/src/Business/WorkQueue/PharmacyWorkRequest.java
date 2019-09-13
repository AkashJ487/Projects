/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

/**
 *
 * @author JAGTAP
 */
public class PharmacyWorkRequest extends WorkRequest{
    private int requestQuantity;
    private boolean add;
    
    public PharmacyWorkRequest(){
        add = false;
    }
    
    public int getQuantity() {
        return requestQuantity;
    }

    public void setQuantity(int quantity) {
        this.requestQuantity = quantity;
    }

    public boolean isAdd() {
        return add;
    }

    public void setAdd(boolean add) {
        this.add = add;
    }

   
}
