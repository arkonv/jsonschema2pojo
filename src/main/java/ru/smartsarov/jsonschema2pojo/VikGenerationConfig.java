package ru.smartsarov.jsonschema2pojo;

import java.io.File;
import java.io.FileFilter;
import java.net.URL;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

import org.jsonschema2pojo.AllFileFilter;
import org.jsonschema2pojo.AnnotationStyle;
import org.jsonschema2pojo.Annotator;
import org.jsonschema2pojo.GenerationConfig;
import org.jsonschema2pojo.InclusionLevel;
import org.jsonschema2pojo.Language;
import org.jsonschema2pojo.NoopAnnotator;
import org.jsonschema2pojo.SourceSortOrder;
import org.jsonschema2pojo.SourceType;
import org.jsonschema2pojo.rules.RuleFactory;

/**
 * A generation config that returns default values for all behavioural options.
 */
public class VikGenerationConfig implements GenerationConfig {

    /**
     * @return <code>false</code>
     */
    @Override
    public boolean isGenerateBuilders() {
        return false;
    }

    /**
     * @return <code>false</code>
     */
    @Override
    public boolean isUsePrimitives() {
        return false;
    }

    /**
     * Unsupported since no default source is possible.
     */
    @Override
    public Iterator<URL> getSource() {
        throw new UnsupportedOperationException("No default source available");
    }

    /**
     * @return the current working directory
     */
    @Override
    public File getTargetDirectory() {
        return new File(".");
    }

    /**
     * @return the 'default' package (i.e. an empty string)
     */
    @Override
    public String getTargetPackage() {
        return "";
    }

    /**
     * @return an empty array (i.e. no word delimiters)
     */
    @Override
    public char[] getPropertyWordDelimiters() {
        return new char[] { '-', ' ', '_' };
    }

    /**
     * @return <code>false</code>
     */
    @Override
    public boolean isUseLongIntegers() {
        return false;
    }

    /**
     * @return <code>true</code>
     */
    @Override
    public boolean isUseDoubleNumbers() {
        return true;
    }

    /**
     * @return <code>true</code>
     */
    @Override
    public boolean isIncludeHashcodeAndEquals() {
        return true;
    }

    /**
     * @return <code>true</code>
     */
    @Override
    public boolean isIncludeToString() {
        return true;
    }
    
    /**
     * @return no exclusions
     */
    @Override
    public String[] getToStringExcludes() {
        return new String[] {};
    }

    /**
     * @return {@code false}
     */
    @Override
    public boolean isUseTitleAsClassname() {
        return false;
    }

    /**
     * @return {@link AnnotationStyle#GSON}
     */
    @Override
    public AnnotationStyle getAnnotationStyle() {
        return AnnotationStyle.GSON;
    }

    /**
     * @return {@link InclusionLevel#NON_NULL}
     */
    @Override
    public InclusionLevel getInclusionLevel() {
        return InclusionLevel.NON_NULL;
    }

    /**
     * {@link NoopAnnotator}
     */
    @Override
    public Class<? extends Annotator> getCustomAnnotator() {
        return NoopAnnotator.class;
    }

    @Override
    public Class<? extends RuleFactory> getCustomRuleFactory() {
        return RuleFactory.class;
    }

    /**
     * @return <code>false</code>
     */
    @Override
    public boolean isIncludeJsr303Annotations() {
        return false;
    }

    @Override
    public boolean isIncludeJsr305Annotations() {
        return false;
    }

    @Override
    public boolean isUseOptionalForGetters() { return false; }

    /**
     * @return {@link SourceType#JSON}
     */
    @Override
    public SourceType getSourceType() {
        return SourceType.JSON;
    }

    /**
     * @return UTF-8
     */
    @Override
    public String getOutputEncoding() {
        return "UTF-8";
    }

    /**
     * @return true
     */
    @Override
    public boolean isRemoveOldOutput() {
        return true;
    }

    /**
     * @return true
     */
    @Override
    public boolean isUseJodaDates() {
        return true;
    }

    /**
     * @return true
     */
    @Override
    public boolean isUseJodaLocalDates() {
        return true;
    }

    /**
     * @return true
     */
    @Override
    public boolean isUseJodaLocalTimes() {
        return true;
    }

    /**
     * @return <code>false</code>
     */
    @Override
    public boolean isParcelable() {
        return false;
    }

    /**
     * @return <code>true</code>
     */
    @Override
    public boolean isSerializable() {
        return true;
    }

    @Override
    public FileFilter getFileFilter() {
        return new AllFileFilter();
    }

    /**
     * @return <code>true</code>
     */
    @Override
    public boolean isInitializeCollections() {
        return true;
    }

    @Override
    public String getClassNamePrefix() {
        return "";
    }

    @Override
    public String getClassNameSuffix() {
        return "";
    }

    @Override
    public String[] getFileExtensions() {
        return new String[] {};
    }

    /**
     * @return <code>false</code>
     */
    @Override
    public boolean isUseBigIntegers() {
        return false;
    }

    /**
     * @return <code>false</code>
     */
    @Override
    public boolean isUseBigDecimals() {
        return false;
    }

    /**
     * @return <code>true</code>
     */
    @Override
    public boolean isIncludeConstructors() {
        return true;
    }

    /**
     * @return <code>false</code>
     */
    @Override
    public boolean isConstructorsRequiredPropertiesOnly() {
        return false;
    }

    /**
     * @return <code>true</code>
     */
    @Override
    public boolean isIncludeAdditionalProperties() {
        return true;
    }

    /**
     * @return <code>true</code>
     */
    @Override
    public boolean isIncludeGetters() {
        return true;
    }

    /**
     * @return <code>true</code>
     */
    @Override
    public boolean isIncludeSetters() {
        return true;
    }

    /**
     * @return <code>1.8</code>
     */
    @Override
    public String getTargetVersion() {
        return "1.8";
    }

    /**
     * @return <code>false</code>
     */
    @Override
    public boolean isIncludeDynamicAccessors() {
        return false;
    }

    /**
     * @return <code>false</code>
     */
    @Override
    public boolean isIncludeDynamicGetters() {
        return false;
    }

    /**
     * @return <code>false</code>
     */
    @Override
    public boolean isIncludeDynamicSetters() {
        return false;
    }

    /**
     * @return <code>false</code>
     */
    @Override
    public boolean isIncludeDynamicBuilders() {
        return false;
    }

    @Override
    public String getDateTimeType() {
        return null;
    }

    @Override
    public String getDateType() {
        return null;
    }

    @Override
    public String getTimeType() {
        return null;
    }

    /**
     * @return <code>false</code>
     */
    @Override
    public boolean isFormatDateTimes() {
        return false;
    }

    /**
     * @return <code>false</code>
     */
    @Override
    public boolean isFormatDates() {
        return false;
    }

    /**
     * @return <code>false</code>
     */
    @Override
    public boolean isFormatTimes() {
        return false;
    }

    /**
     * @return "#/."
     */
    @Override
    public String getRefFragmentPathDelimiters() {
        return "#/.";
    }

    @Override
    public String getCustomDatePattern() {
        return null;
    }

    @Override
    public String getCustomTimePattern() {
        return null;
    }

    @Override
    public String getCustomDateTimePattern() {
        return null;
    }

    /**
     * @return {@link SourceSortOrder#OS}
     */
    @Override
    public SourceSortOrder getSourceSortOrder() {
        return SourceSortOrder.OS;
    }
    
    /**
     * @return {@link Language#JAVA}
     */
    @Override
    public Language getTargetLanguage() {
        return Language.JAVA;
    }

    /**
     * @return {@link Collections#emptyMap}
     */
    @Override
    public Map<String, String> getFormatTypeMapping() {
        return Collections.emptyMap();
    }   
}