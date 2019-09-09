class Clientes{
    private String Name, getName;
    private int Id, getId, getCnh, Cnh;

    public void setName(String nome){
        this.Name = nome;
    }
    public String getName(){
        return this.Name;
    }

    public void setId(int ID){
        this.Id = ID;
    }
    public int getId(){
        return this.Id;
    }

    public void setCnh(int CNH){
        this.Cnh = CNH;
    }
    public int getCnh(){
        return this.Cnh;
    }
    /************************************/
//    @Override
    public void Show(){
        System.out.println("\n\tCliente: " + getName());
        System.out.println("\tCarteira de habilitacao: " + getCnh());
        System.out.println("\tID: " + getId());
    }
}
