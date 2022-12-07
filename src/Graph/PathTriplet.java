package Graph;

public class PathTriplet implements Comparable<PathTriplet>{
    int vertex;
    String pathSooFar;
    int weightSoFar;
    PathTriplet(int vertex,String pathSooFar,int weightSoFar){
        this.vertex=vertex;
        this.pathSooFar=pathSooFar;
        this.weightSoFar=weightSoFar;
    }

    @Override
    public int compareTo(PathTriplet o) {
        return this.weightSoFar-o.weightSoFar;
    }
}
