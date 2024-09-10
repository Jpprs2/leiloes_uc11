package leiloestdsat2;

public class ProdutosDTO {
    
    int ID;
    String Nome;
    int valor;
    String Status;
    String id2;

    public ProdutosDTO() {}

    public ProdutosDTO(int ID, String Nome, int valor, String Status, String id2) {
        this.ID = ID;
        this.Nome = Nome;
        this.valor = valor;
        this.Status = Status;
        this.id2 = id2; }

    

    public int getID() {
        return ID;}
    public void setID(int Id) {
        this.ID = Id;}

    public String getNome() {
        return Nome;}
    public void setNome(String Nome) {
        this.Nome = Nome;}
    
    public int getValor() {
        return valor;}
    public void setValor(int valor) {
        this.valor = valor;}

    public String getStatus() {
        return Status;}
    public void setStatus(String Status) {
        this.Status = Status;}

    public String getId2() {
        return id2;}
    public void setId2(String id2) {
        this.id2 = id2;}
    
}
