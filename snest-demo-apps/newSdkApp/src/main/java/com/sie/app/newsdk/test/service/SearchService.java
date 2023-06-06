package com.sie.app.newsdk.test.service;

import com.sie.snest.engine.api.Swagger;
import com.sie.snest.engine.container.Meta;
import com.sie.snest.engine.data.service.ApiSpec;
import com.sie.snest.engine.data.service.BaseService;
import com.sie.snest.engine.model.ModelMeta;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;
import java.util.Map;

/**
 * @author lijun10
 * @date 2023/2/9 15:38
 */
public class SearchService extends BaseService {
    @Override
    public void before(Meta meta) {
        super.before(meta);
    }

    @Override
    public void execute(Meta meta) {
        super.execute(meta);
    }

    @Override
    public void after(Meta meta) {
        super.after(meta);
    }

    @Override
    public Pair<String, List<Swagger.ApiParameter>> getApiParameters(ModelMeta model) {
        return super.getApiParameters(model);
    }

    @Override
    public Map<String, ApiSpec> getContextSpec(ModelMeta model) {
        return super.getContextSpec(model);
    }

    @Override
    public ApiSpec getResultSpec(ModelMeta model) {
        return super.getResultSpec(model);
    }

    @Override
    public Map<String, ApiSpec> getArgsSpec(ModelMeta model) {
        return super.getArgsSpec(model);
    }
}
