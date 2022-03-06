public interface ASetInterface {
    // A est un container des sommets, de longueur variable, car on y insère des elements au fur et a mesure du programme;

    public void ajoute(MBox sommet) ;

    // faut aussi parcourir A pour savoir si un sommet y figure ou pas;

    public boolean estDedans(MBox sommet) ;
}
