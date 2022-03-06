public interface PiInterface {
    //pi est un objet de java , son utilisation en programme me permet de la considerer comme etant une liste d'entiers de longueur max + 1 (voir vertexinterface pour max)
    //dans l'alg : *on extrait pi(sommet) ; *on change pi(sommet)

    public int getValue(MBox sommet) ; //pi.getValue(a) == pi(a) ;
    public void setValue(MBox sommet , int t) ;//revient a faire pi(sommet) = t ;
}
