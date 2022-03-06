public interface PreviousInterface {
    //pere est aussi un objet java dont l'utilisation nous incite a le considerer comme liste de Vertex ;
    //dans l'alg : *on extrait pere(sommet) ; *on change pere(sommet) ;

    public MBox getPrevious(MBox sommet) ; // pere.getPrevious(sommet) == pere_du_sommet ;

    public void setPrevious(MBox sommet , MBox newPrevious) ; // revient a faire : pere(sommet) = newPrevious
}
