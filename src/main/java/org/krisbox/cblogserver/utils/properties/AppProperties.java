
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
        "title",
        "icon",
        "height",
        "width",
        "author",
        "menu",
        "toolbar",
        "shortcodes",
        "formatting",
        "preview"
})
public class AppProperties implements Serializable
{

    @JsonProperty("title")
    private String title;
    @JsonProperty("icon")
    private String icon;
    @JsonProperty("height")
    private int height;
    @JsonProperty("width")
    private int width;
    @JsonProperty("author")
    private Author author;
    @JsonProperty("menu")
    private List<Menu> menu = null;
    @JsonProperty("toolbar")
    private List<Toolbar> toolbar = null;
    @JsonProperty("shortcodes")
    private List<Shortcodes> shortcodes = null;
    @JsonProperty("formatting")
    private List<Formatting> formatting = null;
    @JsonProperty("preview")
    private Preview preview;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -8227052263307275535L;

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    public AppProperties withTitle(String title) {
        this.title = title;
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

    public AppProperties withIcon(String icon) {
        this.icon = icon;
        return this;
    }

    @JsonProperty("height")
    public int getHeight() {
        return height;
    }

    @JsonProperty("height")
    public void setHeight(int height) {
        this.height = height;
    }

    public AppProperties withHeight(int height) {
        this.height = height;
        return this;
    }

    @JsonProperty("width")
    public int getWidth() {
        return width;
    }

    @JsonProperty("width")
    public void setWidth(int width) {
        this.width = width;
    }

    public AppProperties withWidth(int width) {
        this.width = width;
        return this;
    }

    @JsonProperty("author")
    public Author getAuthor() {
        return author;
    }

    @JsonProperty("author")
    public void setAuthor(Author author) {
        this.author = author;
    }

    public AppProperties withAuthor(Author author) {
        this.author = author;
        return this;
    }

    @JsonProperty("menu")
    public List<Menu> getMenu() {
        return menu;
    }

    @JsonProperty("menu")
    public void setMenu(List<Menu> menu) {
        this.menu = menu;
    }

    public AppProperties withMenu(List<Menu> menu) {
        this.menu = menu;
        return this;
    }

    @JsonProperty("toolbar")
    public List<Toolbar> getToolbar() {
        return toolbar;
    }

    @JsonProperty("toolbar")
    public void setToolbar(List<Toolbar> toolbar) {
        this.toolbar = toolbar;
    }

    public AppProperties withToolbar(List<Toolbar> toolbar) {
        this.toolbar = toolbar;
        return this;
    }

    @JsonProperty("shortcodes")
    public List<Shortcodes> getShortcodes() {
        return shortcodes;
    }

    @JsonProperty("shortcodes")
    public void setShortcodes(List<Shortcodes> shortcodes) {
        this.shortcodes = shortcodes;
    }

    public AppProperties withShortcodes(List<Shortcodes> shortcodes) {
        this.shortcodes = shortcodes;
        return this;
    }

    @JsonProperty("formatting")
    public List<Formatting> getFormatting() {
        return formatting;
    }

    @JsonProperty("formatting")
    public void setFormatting(List<Formatting> formatting) {
        this.formatting = formatting;
    }

    public AppProperties withFormatting(List<Formatting> formatting) {
        this.formatting = formatting;
        return this;
    }

    @JsonProperty("preview")
    public Preview getPreview() {
        return preview;
    }

    @JsonProperty("preview")
    public void setPreview(Preview preview) {
        this.preview = preview;
    }

    public AppProperties withPreview(Preview preview) {
        this.preview = preview;
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

    public AppProperties withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(title).append(icon).append(height).append(width).append(author).append(menu).append(toolbar).append(shortcodes).append(formatting).append(preview).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AppProperties) == false) {
            return false;
        }
        AppProperties rhs = ((AppProperties) other);
        return new EqualsBuilder().append(title, rhs.title).append(icon, rhs.icon).append(height, rhs.height).append(width, rhs.width).append(author, rhs.author).append(menu, rhs.menu).append(toolbar, rhs.toolbar).append(shortcodes, rhs.shortcodes).append(formatting, rhs.formatting).append(preview, rhs.preview).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}