package Business;

import Business.CDC.DiseaseDirectory;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Role.CDCAdminRole;
import Business.Role.DistributorAdminRole;
import Business.Role.HospitalAdminRole;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import Business.Supplier.VaccineDirectory;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author JAGTAP
 */
public class EcoSystem extends Organization {

    private static EcoSystem business;
    private ArrayList<Network> networkList;
    private VaccineDirectory vaccineList;
    private DiseaseDirectory diseaseList;

    public static EcoSystem getInstance() {
        if (business == null) {
            business = new EcoSystem();
        }
        return business;
    }

    private EcoSystem() {
        super(null);
        networkList = new ArrayList<>();
       vaccineList= new VaccineDirectory();
       diseaseList= new DiseaseDirectory();
    }

    public ArrayList<Network> getNetworkList() {
        return networkList;
    }

    public VaccineDirectory getVaccineList() {
        return vaccineList;
    }

    public void setVaccineList(VaccineDirectory vaccineList) {
        this.vaccineList = vaccineList;
    }
    
    public static void setInstance(EcoSystem system) {
        business=system;
    }
    
    public DiseaseDirectory getDiseaseList() {
        return diseaseList;
    }
    
    
    public void setDiseaseList(DiseaseDirectory diseaseList) {
        this.diseaseList = diseaseList;
    }

    public Network createAndAddNetwork() {
        Network network = new Network();
        networkList.add(network);
        return network;
    }

    @Override
    public HashSet<Role> getSupportedRole() {
        roles.add(new SystemAdminRole());
        roles.add(new HospitalAdminRole());
        roles.add(new DistributorAdminRole());
        roles.add(new CDCAdminRole());
        return roles;
    }

    public static boolean checkIfUsernameIsUnique(String username) {

      //  if (!this.getUserAccountDirectory().checkIfUsernameIsUnique(username)) {
             for (Network network : business.getNetworkList()) {
                 
                for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                    for (UserAccount ua : enterprise.getUserAccountDirectory().getUserAccountList()) {
                        if(ua.getUsername().equals(username)){
                            return false;
                        }
                    }
                    
                        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                            for (UserAccount ua : organization.getUserAccountDirectory().getUserAccountList()) {
                                 if(ua.getUsername().equals(username)){
                            return false;
                        }
                    }
                            }
                        }
                    }
            
      //  }

       

        return true;
    }
}