package com.hailong.jpafortsy;

import com.hailong.jpafortsy.dao.UserDao;
import com.hailong.jpafortsy.dao.UserDaoTemplat;
import com.hailong.jpafortsy.dbmodel.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaForTsyApplicationTests {

    @Autowired
    public UserDaoTemplat userDaoTemplat;

    @Autowired
    public UserDao userDao;

    @Test
    public void test(){
        User user = new User();
        user.setUserName("test");
        userDaoTemplat.addUser(user);
        System.out.println(user);

    }

//    create table tsy_orderdetail
//            (
//                    id int auto_increment
//                    primary key,
//                    ordernumber text null,
//                    productnumber text null,
//                    product text null,
//                    quantity text null,
//                    price text null,
//                    danjia text null,
//                    danwei text null,
//                    danweiname text null,
//                    danweiupname text null,
//                    danweiupjishu text null,
//                    xiaoji text null,
//                    jiliang text null,
//                    fandian text null,
//                    productdata text null
//            )
//            ;
//

//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//    @Test
//    public void contextLoads() {
////        jdbcTemplate.batchUpdate("")
//        Map<String, Object> count = jdbcTemplate.queryForMap("select count(*) count from tsy_orderdetail");
//        int ox = Integer.parseInt(count.get("count").toString());
//        System.out.println("原有数据：   =========" +ox +"条");
//        jdbcTemplate.batchUpdate("TRUNCATE table tsy_orderdetail");
//        System.out.println("清空订单详情");
//        System.out.println("开始新增数据");
//        int x =0;
//        System.out.println("==================================================================================");
//        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from temp_orderlist");
//        ArrayList<Map<String, Object>> maps1 = new ArrayList<>();
//        for (int i = 0; i < maps.size(); i++) {
//            String odernumber = maps.get(i).get("odernumber").toString();
//            List<Map<String, Object>> maps2 = jdbcTemplate.queryForList("select * from tsy_" + odernumber);
//            for (int j = 0; j < maps2.size(); j++) {
//                Map<String, Object> stringObjectMap = maps2.get(j);
//                stringObjectMap.put("ordernumber",odernumber);
//                System.out.println(sqlInit(stringObjectMap)+";");
//                int[] ints = jdbcTemplate.batchUpdate(sqlInit(stringObjectMap));
//                x++;
//            }
//        }
//        System.out.println("==================================================================================");
//        System.out.println("成功更新:" + x +" - " +ox +" = " + (x-ox) +"条");

//    }

    private String sqlInit(Map<String,Object> param){

        StringBuilder key = new StringBuilder("");
        StringBuilder value = new StringBuilder("value");
        key.append("(");
        value.append("(");
        for (Map.Entry<String,Object> entry: param.entrySet()
             ) {
            key.append(entry.getKey()+",");
            value.append("'"+entry.getValue()+"',");
        }
        key.deleteCharAt(key.length()-1);
        value.deleteCharAt(value.length()-1);
        key.append(")");
        value.append(")");


        return "insert into tsy_orderdetail "+key + value;
    }
}
