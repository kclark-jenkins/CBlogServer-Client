
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
        "author",
        "authorEmail",
        "copyrite",
        "license"
})
public class Author implements Serializable
{

    @JsonProperty("author")
    private String author;
    @JsonProperty("authorEmail")
    private String authorEmail;
    @JsonProperty("copyrite")
    private String copyrite;
    @JsonProperty("license")
    private String license;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -6663228077210406909L;

    @JsonProperty("author")
    public String getAuthor() {
        return author;
    }

    @JsonProperty("author")
    public void setAuthor(String author) {
        this.author = author;
    }

    public Author withAuthor(String author) {
        this.author = author;
        return this;
    }

    @JsonProperty("authorEmail")
    public String getAuthorEmail() {
        return authorEmail;
    }

    @JsonProperty("authorEmail")
    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
    }

    public Author withAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
        return this;
    }

    @JsonProperty("copyrite")
    public String getCopyrite() {
        return copyrite;
    }

    @JsonProperty("copyrite")
    public void setCopyrite(String copyrite) {
        this.copyrite = copyrite;
    }

    public Author withCopyrite(String copyrite) {
        this.copyrite = copyrite;
        return this;
    }

    @JsonProperty("license")
    public String getLicense() {
        return license;
    }

    @JsonProperty("license")
    public void setLicense(String license) {
        this.license = license;
    }

    public Author withLicense(String license) {
        this.license = license;
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

    public Author withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(author).append(authorEmail).append(copyrite).append(license).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Author) == false) {
            return false;
        }
        Author rhs = ((Author) other);
        return new EqualsBuilder().append(author, rhs.author).append(authorEmail, rhs.authorEmail).append(copyrite, rhs.copyrite).append(license, rhs.license).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
