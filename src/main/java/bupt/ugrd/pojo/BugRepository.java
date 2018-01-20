package bupt.ugrd.pojo;

/**
 * Created by Luyao on 2018/1/20.
 */

import org.springframework.data.repository.CrudRepository;
import bupt.ugrd.pojo.Bug;

public interface BugRepository extends CrudRepository<Bug, Long>{
}
