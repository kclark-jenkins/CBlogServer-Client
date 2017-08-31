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
        "title",
        "header",
        "copiedHeader",
        "copiedText"
})
public class Preview implements Serializable
{

    @JsonProperty("title")
    private String title;
    @JsonProperty("header")
    private String header;
    @JsonProperty("copiedHeader")
    private String copiedHeader;
    @JsonProperty("copiedText")
    private String copiedText;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 3386098933802960548L;

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    public Preview withTitle(String title) {
        this.title = title;
        return this;
    }

    @JsonProperty("header")
    public String getHeader() {
        return header;
    }

    @JsonProperty("header")
    public void setHeader(String header) {
        this.header = header;
    }

    public Preview withHeader(String header) {
        this.header = header;
        return this;
    }

    @JsonProperty("copiedHeader")
    public String getCopiedHeader() {
        return copiedHeader;
    }

    @JsonProperty("copiedHeader")
    public void setCopiedHeader(String copiedHeader) {
        this.copiedHeader = copiedHeader;
    }

    public Preview withCopiedHeader(String copiedHeader) {
        this.copiedHeader = copiedHeader;
        return this;
    }

    @JsonProperty("copiedText")
    public String getCopiedText() {
        return copiedText;
    }

    @JsonProperty("copiedText")
    public void setCopiedText(String copiedText) {
        this.copiedText = copiedText;
    }

    public Preview withCopiedText(String copiedText) {
        this.copiedText = copiedText;
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

    public Preview withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(title).append(header).append(copiedHeader).append(copiedText).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Preview) == false) {
            return false;
        }
        Preview rhs = ((Preview) other);
        return new EqualsBuilder().append(title, rhs.title).append(header, rhs.header).append(copiedHeader, rhs.copiedHeader).append(copiedText, rhs.copiedText).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}