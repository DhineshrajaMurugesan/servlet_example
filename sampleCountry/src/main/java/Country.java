public class Country {
    private int id;
    private String name;
    private String abrrev;
    Country(int id, String name, String abrrev) {
    this.id = id;
    this.name = name;
    this.abrrev = abrrev;
    }
    /**
    * @return the id
    
    */
    public int getId() {
    return id;
    }
    /**
    
    * @param id the id to set
    
    */
    public void setId(int id) {
    
    this.id = id;
    
    }
    /**
    
    * @return the name
    
    */
    
    public String getName() {
    
    return name;
    
    }
    /**
    
    * @param name the name to set
    
    */
    
    public void setName(String name) {
    
    this.name = name;
    
    }

    /**
    
    * @return the abrrev
    
    */
    
    public String getAbrrev() {
    
    return abrrev;
    
    }
     
    /**
    
    * @param abrrev the abrrev to set
    
    */
    
    public void setAbrrev(String abrrev) {
    
    this.abrrev = abrrev;
    
    }
    @Override
    public String toString() {
    return id + " " + name + " " + abrrev;
    
    }
    
    }
    
    