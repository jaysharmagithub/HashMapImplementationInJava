import java.util.Arrays;
public class HashMaps{
    //field 
    public String[] hashmap;

    public HashMaps(int size) {
        //instantiated the hashMap as a String array
        //this.hashmap = new String[size];

        //instantiated the hashMap as a linked list
        this.hashmap = new LinkedList[size];
        for(int i = 0; i < size; i++){
            this.hashmap[i] = new LinkedList();
        }

    }
    
    //below code gives hashCode for the HashMap
    public int hash(String key){
        int hashCode = 0;
        for(int i=0; i< key.length(); i++){
            hashCode = hashCode + Character.codePointAt(key, i);
        }
        //compressed the hashcode
        hashCode = hashCode % this.hashmap.length;
        return hashCode;

    }

    //Assign the value to the index(hashCode) that we generated
    public void assign(String key, String value){

        int arrayIndex = this.hash(key);
        LinkedList list = this.hashmap[arrayIndex];
        if (list.head != null) {
            list.addToHead(key,value);
            return;
        }
        this.hashmap[arrayIndex] = value;
        return ;
    } 
    //Retrieve 
    public String retrieve(String key){
        int arrayIndex = this.hash(key);
        return this.hashmap[arrayIndex];

    }

    public static void main(String[] args) {
       HashMaps newHashMap = new HashMaps(1);
       System.out.println(newHashMap.hash("c"));
       System.out.println(newHashMap.hash("ca"));
       System.out.println(newHashMap.hash("car"));

       HashMaps employees = new HashMaps(3);
       employees.assign("34-567", "Mara");
       System.out.println(Arrays.toString(employees.hashmap));

       HashMaps aboutMe = new HashMaps(3);
       aboutMe.assign("myFavouriteColor", "brown");
       System.out.println(aboutMe.retrieve("myFavouriteColor"));
    }

    
}