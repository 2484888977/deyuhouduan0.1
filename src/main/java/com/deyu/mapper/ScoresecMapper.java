package com.deyu.mapper;

import com.deyu.pojo.Scoresec;
import com.deyu.pojo.Scoresec_view;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ScoresecMapper {
    //添加二级学分
    int addScoresec(Scoresec scoresec);
    //更改二级学分记录
    int updatScoresec(Scoresec scoresec);
    //删除
    int deleteScoresec(@Param("scoresecid")int scoresecid);
    //查看二级学分记录
    List<Scoresec_view> selectScoresec(@Param("page")int page,@Param("limit")int limit,@Param("Keyword")String Keyword);
    //关键字查询
    List<Scoresec_view> selectWhereScoresec(@Param("Keyword")String keyword);
    //查看编辑
    List<Scoresec_view> queryScoresec(@Param("scoresecid")int scoresecid);
    //一二级查看
    List<Scoresec_view> queryallScoresec(@Param("scorefirid")int scorefrid);

}
