package leiloestdsat2;

public class ProdutosDTO {
    
    int ID;
    String Nome;
    int valor;
    String Status;

    public ProdutosDTO() {}

    public ProdutosDTO(int Id, String Nome, int valor, String Status) {
        this.ID = Id;
        this.Nome = Nome;
        this.valor = valor;
        this.Status = Status;
    }

    public int getId() {
        return ID;}
    public void setId(int Id) {
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
}
