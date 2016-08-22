package me.mushen.athena.spring.handler;

import com.google.common.base.Strings;
import me.mushen.athena.spring.util.BaseThriftUtil;
import me.mushen.thrift.athena.AthenaService;
import me.mushen.thrift.base.StringResult;
import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-07-15
 */
public class AthenaHandler implements AthenaService.Iface {
    private static final Logger LOGGER = LoggerFactory.getLogger(AthenaHandler.class);

    @Override
    public StringResult sayHello(String name) throws TException {
        StringResult strResult = new StringResult(BaseThriftUtil.successResult());

        if(Strings.isNullOrEmpty(name)){
            strResult.setResult(BaseThriftUtil.failureResult("用户名不能为空"));
        }else{
            strResult.setStrValue("Hello, " + name);
        }

        return strResult;
    }
}
