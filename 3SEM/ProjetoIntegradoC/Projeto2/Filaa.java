public class Fila <T> {
    
    
    
    protected Object []f;
    protected int inicio;
    protected int fim;
    
    //construtor
    public Fila(int tamanho) throws Exception
    {
        this.f = new Object [tamanho];
        this.inicio = 0;
        this.fim = 0;        
    }
    
    public boolean isEmpty()
    {
        if(this.inicio == this.fim-1)
        {
            return true;
        }
        return false;
    }
    
    
    //metodo para tirar da fila
    public Object pop()
    {
        if(isEmpty()==true)
        {
            System.out.println("Fila vazia");
        }
        Object ret = this.f[this.inicio];//tem que tirar da fila
        this.inicio--;
        return ret;
    }
    
    //metodo para adicionar na fila
    //metodo deve aceitar chars, strings, int 
    //modificar para metodo generico 
    public Object push(Object valor)
    {
        if(this.inicio == this.f.length-1)
        {
            System.out.println("Fila cheia");
        }
        this.f[this.inicio] = valor;
        Object ret = this.f[this.inicio];
        this.inicio++;
        if(this.inicio == this.f.length)
        {
            this.inicio=0;
        }
        return ret;
    }
    
    
    //METODOS CANONICOS (OBRIGATORIOS)
    
    //...
    public boolean equals (Object obj) 
{
    if(this==obj)
    {
        return true;
    }
    if(obj == null)
    {
        return false;
    }
    if(!(obj instanceof Fila))
    {
        return false;
    }
    Fila fil =  (Fila) obj; 
    if(this.fim != fil.fim)
    {
        return false;
    } 
    for ( int i =0; i<= this.fim; i++)
    {
        if(this.f[i] != fil.f[i])
        {
            return false;
        }
    }   
    return true;
}
    
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Arrays.deepHashCode(this.f);
        hash = 53 * hash + this.inicio;
        hash = 53 * hash + this.fim;
        return hash;
    }
    
    public String toString() {
        return "Fila{" + "f=" + f.length + '}';
    }

    
    
    //METODOS CANONICOS (OBRIGATORIOS AS VEZES)
    
    //...
    public Object compareTo(Fila outro)
    {
        return 0;
    }
    
    
}
