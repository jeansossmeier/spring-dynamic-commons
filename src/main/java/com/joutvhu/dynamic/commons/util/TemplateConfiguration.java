package com.joutvhu.dynamic.commons.util;

import com.joutvhu.dynamic.commons.directive.SetDirective;
import com.joutvhu.dynamic.commons.directive.TrimDirective;
import com.joutvhu.dynamic.commons.directive.WhereDirective;
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;

/**
 * Freemarker configuration builder.
 *
 * @author Giao Ho
 * @since 1.0.0
 */
public class TemplateConfiguration {
    private Configuration cfg;

    protected TemplateConfiguration() {
        this.cfg = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
    }

    public static TemplateConfiguration instance() {
        return new TemplateConfiguration();
    }

    public static TemplateConfiguration instanceWithDefault() {
        return instance().applyDefault();
    }

    public TemplateConfiguration applyDefault() {
        cfg.setTagSyntax(Configuration.ANGLE_BRACKET_TAG_SYNTAX);
        cfg.setInterpolationSyntax(Configuration.DOLLAR_INTERPOLATION_SYNTAX);

        cfg.setSharedVariable("trim", new TrimDirective());
        cfg.setSharedVariable("set", new SetDirective());
        cfg.setSharedVariable("where", new WhereDirective());

        return this;
    }

    public TemplateConfiguration templateLoader(TemplateLoader templateLoader) {
        cfg.setTemplateLoader(templateLoader);
        return this;
    }

    public Configuration configuration() {
        return cfg;
    }
}
