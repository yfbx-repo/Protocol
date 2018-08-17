package com.yfbx.protocol.protocol;

import com.yfbx.protocol.protocol.params.Params;

/**
 * Author:Edward
 * Date:2018/6/25
 * Description:
 */

public interface Protocol {


    <T> T getData(Params params);

}
