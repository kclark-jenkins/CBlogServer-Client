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
        "hotkey",
        "icon",
        "fontpack",
        "shortcode",
        "translated"
})
public class Toolbar implements Serializable
{

    @JsonProperty("name")
    private String name;
    @JsonProperty("display")
    private String display;
    @JsonProperty("hotkey")
    private String hotkey;
    @JsonProperty("icon")
    private String icon;
    @JsonProperty("fontpack")
    private String fontpack;
    @JsonProperty("shortcode")
    private String shortcode;
    @JsonProperty("translated")
    private String translated;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 9095236859999174633L;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public Toolbar withName(String name) {
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

    public Toolbar withDisplay(String display) {
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

    public Toolbar withHotkey(String hotkey) {
        this.hotkey = hotkey;
        return this;
    }

    @JsonProperty("icon")
    public String getIcon() {
        return icon;
    }

    @JsonProperty("icon")
    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Toolbar withIcon(String icon) {
        this.icon = icon;
        return this;
    }

    @JsonProperty("fontpack")
    public String getFontpack() {
        return fontpack;
    }

    @JsonProperty("fontpack")
    public void setFontpack(String fontpack) {
        this.fontpack = fontpack;
    }

    public Toolbar withFontpack(String fontpack) {
        this.fontpack = fontpack;
        return this;
    }

    @JsonProperty("shortcode")
    public String getShortcode() {
        return shortcode;
    }

    @JsonProperty("shortcode")
    public void setShortcode(String shortcode) {
        this.shortcode = shortcode;
    }

    public Toolbar withShortcode(String shortcode) {
        this.shortcode = shortcode;
        return this;
    }

    @JsonProperty("translated")
    public String getTranslated() {
        return translated;
    }

    @JsonProperty("translated")
    public void setTranslated(String translated) {
        this.translated = translated;
    }

    public Toolbar withTranslated(String translated) {
        this.translated = translated;
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

    public Toolbar withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(name).append(display).append(hotkey).append(icon).append(fontpack).append(shortcode).append(translated).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Toolbar) == false) {
            return false;
        }
        Toolbar rhs = ((Toolbar) other);
        return new EqualsBuilder().append(name, rhs.name).append(display, rhs.display).append(hotkey, rhs.hotkey).append(icon, rhs.icon).append(fontpack, rhs.fontpack).append(shortcode, rhs.shortcode).append(translated, rhs.translated).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}