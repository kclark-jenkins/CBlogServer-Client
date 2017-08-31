package org.krisbox.cblogserver.utils.properties;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "code",
        "regex",
        "html"
})
public class Shortcodes implements Serializable
{

    @JsonProperty("code")
    private String code;
    @JsonProperty("regex")
    private Regex regex;
    @JsonProperty("html")
    private Html html;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 5469251990520659199L;

    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    @JsonProperty("code")
    public void setCode(String code) {
        this.code = code;
    }

    public Shortcodes withCode(String code) {
        this.code = code;
        return this;
    }

    @JsonProperty("regex")
    public Regex getRegex() {
        return regex;
    }

    @JsonProperty("regex")
    public void setRegex(Regex regex) {
        this.regex = regex;
    }

    public Shortcodes withRegex(Regex regex) {
        this.regex = regex;
        return this;
    }

    @JsonProperty("html")
    public Html getHtml() {
        return html;
    }

    @JsonProperty("html")
    public void setHtml(Html html) {
        this.html = html;
    }

    public Shortcodes withHtml(Html html) {
        this.html = html;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Shortcodes withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(code).append(regex).append(html).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Shortcodes) == false) {
            return false;
        }
        Shortcodes rhs = ((Shortcodes) other);
        return new EqualsBuilder().append(code, rhs.code).append(regex, rhs.regex).append(html, rhs.html).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
