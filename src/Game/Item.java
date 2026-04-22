package Game;

import app.Result;
import java.util.UUID;

public abstract class Item implements Interactable {
    private UUID id;
    private String name;

    public Item(String name){
        if (name == null || name.isEmpty()){
            throw new IllegalStateException();
        }

        this.id = UUID.randomUUID();
        this.name = name;
    }

    public UUID getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public Result<String> setName(String name){
        if (name != null && !name.isEmpty()) {
            this.name = name;
            return new Result<String>(true, name, null);
        } else {
            return new Result<String>(false, null, "Name не может быть пустым");
        }
    }
}
