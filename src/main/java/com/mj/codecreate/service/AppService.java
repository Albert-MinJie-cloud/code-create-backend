package com.mj.codecreate.service;

import com.mj.codecreate.model.dto.AppQueryRequest;
import com.mj.codecreate.model.entity.App;
import com.mj.codecreate.model.vo.AppVO;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.service.IService;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

/**
 * 应用 服务层。
 *
 * @author <a href="https://github.com/Albert-MinJie-cloud">MJ</a>
 */
public interface AppService extends IService<App> {

    /**
     * 校验应用参数
     *
     * @param app  应用实体
     * @param isAdd 是否为创建操作
     */
    void validApp(App app, boolean isAdd);

    /**
     * 获取应用 VO
     *
     * @param app 应用实体
     * @return 应用 VO
     */
    AppVO getAppVO(App app);


    /**
     * 批量获取应用 VO 列表
     *
     * @param appList 应用列表
     * @return 应用 VO 列表
     */
    List<AppVO> getAppVOList(List<App> appList);

    /**
     * 根据查询条件构造 QueryWrapper
     *
     * @param appQueryRequest 查询请求
     * @return QueryWrapper
     */
    QueryWrapper getQueryWrapper(AppQueryRequest appQueryRequest);

    /**
     * 获取当前登录用户
     *
     * @param request 请求对象
     * @return 应用实体
     */
    App getAppByIdWithAuth(Long id, HttpServletRequest request);
}
