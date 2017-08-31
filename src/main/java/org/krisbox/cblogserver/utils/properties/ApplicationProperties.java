
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
        "appProperties"
})
public class ApplicationProperties implements Serializable
{

    @JsonProperty("appProperties")
    private AppProperties appProperties;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -3097728981294747981L;

    @JsonProperty("appProperties")
    public AppProperties getAppProperties() {
        return appProperties;
    }

    @JsonProperty("appProperties")
    public void setAppProperties(AppProperties appProperties) {
        this.appProperties = appProperties;
    }

    public ApplicationProperties withAppProperties(AppProperties appProperties) {
        this.appProperties = appProperties;
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

    public ApplicationProperties withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(appProperties).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ApplicationProperties) == false) {
            return false;
        }
        ApplicationProperties rhs = ((ApplicationProperties) other);
        return new EqualsBuilder().append(appProperties, rhs.appProperties).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
