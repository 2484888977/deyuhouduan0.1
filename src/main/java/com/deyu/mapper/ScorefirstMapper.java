package com.deyu.mapper;

import com.deyu.pojo.Scorefir_view;
import com.deyu.pojo.Scorefirst;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ScorefirstMapper {
    //添加学分记录一级分类
    int addScorefirst(Scorefirst scorefirst);
    //修改学分
    int updateScore(Scorefirst scorefirst);
    //删除
    int deleteScore(@Param("scoreid")int scoreid);
    //查看学分
    List<Scorefir_view> selectfirScore(@Param("page")int page,@Param("limit")int limit,@Param("Keyword")String Keyword);
    //关键字查询
    List<Scorefir_view> selecrfirWhereScore(@Param("Keyword")String Keyword);
    //查看编辑
    List<Scorefir_view> queryScorefir(@Param("scoreid")int scoreid);
    //查看全部
    List<Scorefir_view> selectAll();
}
