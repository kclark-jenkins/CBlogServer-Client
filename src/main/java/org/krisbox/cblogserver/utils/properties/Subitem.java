
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
        "name",
        "display",
        "hotkey"
})
public class Subitem implements Serializable
{

    @JsonProperty("name")
    private String name;
    @JsonProperty("display")
    private String display;
    @JsonProperty("hotkey")
    private String hotkey;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -2205952074220092013L;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public Subitem withName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("display")
    public String getDisplay() {
        return display;
    }

    @JsonProperty("display")
    public void setDisplay(String display) {
        this.display = display;
    }

    public Subitem withDisplay(String display) {
        this.display = display;
        return this;
    }

    @JsonProperty("hotkey")
    public String getHotkey() {
        return hotkey;
    }

    @JsonProperty("hotkey")
    public void setHotkey(String hotkey) {
        this.hotkey = hotkey;
    }

    public Subitem withHotkey(String hotkey) {
        this.hotkey = hotkey;
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

    public Subitem withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(name).append(display).append(hotkey).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Subitem) == false) {
            return false;
        }
        Subitem rhs = ((Subitem) other);
        return new EqualsBuilder().append(name, rhs.name).append(display, rhs.display).append(hotkey, rhs.hotkey).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
