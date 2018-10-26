public class TreeTile extends Tile{

    public TreeTile(int id){
        super(Assets.tree, id);
    }

    //overrides the parent class method, because you can't walk through trees
    @Override
    public boolean isSolid(){
        return true;
    }
}
