package priv.zzz.dao;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface UserDao {
    @Select("select * from user limit 5")
    public List<Map<String, Object>> query();
}
