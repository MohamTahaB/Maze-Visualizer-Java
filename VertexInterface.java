public interface VertexInterface {
    // un sommet va etre represente pour le moment par un entier sup a 0 , le critere est que le graphe contienne un segment non discontinu d'entieres de 0 a n, ce qui impose une variable de classe Vertex qui memorise le nombre maximum affecte, et new Vertex entraine un sommet de nombre max + 1 ; et on incremente max de 1 ;
    // pour le moment , je vais representer graph comme un table multidim de taille fixe , donc max sera final static pour le moment ;
    // l'alg ne fait que : * comparer les sommets

    public boolean equals(MBox sommet) ;

    // a.estIdentiqueA(b) == true <==> a == b

    public String getLabel() ;

    public int getX() ;
    public int getY() ;
}
