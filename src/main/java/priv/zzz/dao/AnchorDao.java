package priv.zzz.dao;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface AnchorDao {
    @Select("select * from anchor limit 5")
    public List<Map<String, Object>> query();
}
