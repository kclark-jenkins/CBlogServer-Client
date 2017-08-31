
package org.krisbox.cblogserver.utils.properties;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
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
        "hotkey",
        "subitems"
})
public class Menu implements Serializable
{

    @JsonProperty("name")
    private String name;
    @JsonProperty("display")
    private String display;
    @JsonProperty("hotkey")
    private String hotkey;
    @JsonProperty("subitems")
    private List<Subitem> subitems = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -7244184266620554450L;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public Menu withName(String name) {
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

    public Menu withDisplay(String display) {
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

    public Menu withHotkey(String hotkey) {
        this.hotkey = hotkey;
        return this;
    }

    @JsonProperty("subitems")
    public List<Subitem> getSubitems() {
        return subitems;
    }

    @JsonProperty("subitems")
    public void setSubitems(List<Subitem> subitems) {
        this.subitems = subitems;
    }

    public Menu withSubitems(List<Subitem> subitems) {
        this.subitems = subitems;
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

    public Menu withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(name).append(display).append(hotkey).append(subitems).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Menu) == false) {
            return false;
        }
        Menu rhs = ((Menu) other);
        return new EqualsBuilder().append(name, rhs.name).append(display, rhs.display).append(hotkey, rhs.hotkey).append(subitems, rhs.subitems).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
