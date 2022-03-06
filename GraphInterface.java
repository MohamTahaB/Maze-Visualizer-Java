public interface GraphInterface {
    // Graph sera modelise comme matrice d adjacence, par une table de taille (max+1)*(max+1) (voir VertexInterface pour max)
    // dans l'alg , on cherche souvent les successeurs et peres de sommets ;

    public boolean premierEstSuccesseurDuDeuxieme(MBox a , MBox b) ;

    public boolean premierEstPereDuDeuxieme(MBox a , MBox b) ;
    // suffit de faire l'une pour retrouver l'autre : premierEstSuccesseurDuDeuxieme(a , b) == premierEstPereDuDeuxieme(b , a)

}
