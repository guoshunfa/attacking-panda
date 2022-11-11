package com.panda.common.base;

import com.panda.common.result.ApiResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 基础控制器
 *
 * @className: BaseController
 * @author: GuoShunFa
 * @date: 2022/11/10
 **/
public abstract class BaseController<T extends BaseEntity> {

    protected final Logger logger = LoggerFactory.getLogger(BaseController.class);

    /**
     * 响应返回结果
     *
     * @param rows 影响行数
     * @return 操作结果
     */
    protected ApiResult toAjax(int rows) {
        return rows > 0 ? ApiResult.ok() : ApiResult.fail();
    }

    /**
     * 响应返回结果
     *
     * @param result 结果
     * @return 操作结果
     */
    protected ApiResult toAjax(boolean result) {
        return result ? ApiResult.ok() : ApiResult.fail();
    }
}
