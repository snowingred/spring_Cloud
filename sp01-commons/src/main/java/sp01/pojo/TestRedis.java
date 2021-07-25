package sp01.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;
import sp01.pojo.Item;
import sp01.pojo.User;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestRedis {
    private String id;
    private String name;
}
