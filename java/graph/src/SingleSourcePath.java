/**
 * Unweighted Single Source Path
 */
public interface SingleSourcePath {

    /**
     * 判断是否可达
     * @param t
     * @return
     */
    boolean isConnectedTo(int t);

    /**
     * 路径
     * @param t
     * @return
     */
    Iterable<Integer> path(int t);

}
