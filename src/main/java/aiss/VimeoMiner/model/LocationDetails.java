
package aiss.VimeoMiner.model;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "formatted_address",
    "latitude",
    "longitude",
    "city",
    "state",
    "neighborhood",
    "sub_locality",
    "state_iso_code",
    "country",
    "country_iso_code"
})
@Generated("jsonschema2pojo")
public class LocationDetails {

    @JsonProperty("formatted_address")
    private String formattedAddress;
    @JsonProperty("latitude")
    private Double latitude;
    @JsonProperty("longitude")
    private Double longitude;
    @JsonProperty("city")
    private String city;
    @JsonProperty("state")
    private String state;
    @JsonProperty("neighborhood")
    private Object neighborhood;
    @JsonProperty("sub_locality")
    private Object subLocality;
    @JsonProperty("state_iso_code")
    private String stateIsoCode;
    @JsonProperty("country")
    private String country;
    @JsonProperty("country_iso_code")
    private String countryIsoCode;

    @JsonProperty("formatted_address")
    public String getFormattedAddress() {
        return formattedAddress;
    }

    @JsonProperty("formatted_address")
    public void setFormattedAddress(String formattedAddress) {
        this.formattedAddress = formattedAddress;
    }

    @JsonProperty("latitude")
    public Double getLatitude() {
        return latitude;
    }

    @JsonProperty("latitude")
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    @JsonProperty("longitude")
    public Double getLongitude() {
        return longitude;
    }

    @JsonProperty("longitude")
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty("state")
    public String getState() {
        return state;
    }

    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    @JsonProperty("neighborhood")
    public Object getNeighborhood() {
        return neighborhood;
    }

    @JsonProperty("neighborhood")
    public void setNeighborhood(Object neighborhood) {
        this.neighborhood = neighborhood;
    }

    @JsonProperty("sub_locality")
    public Object getSubLocality() {
        return subLocality;
    }

    @JsonProperty("sub_locality")
    public void setSubLocality(Object subLocality) {
        this.subLocality = subLocality;
    }

    @JsonProperty("state_iso_code")
    public String getStateIsoCode() {
        return stateIsoCode;
    }

    @JsonProperty("state_iso_code")
    public void setStateIsoCode(String stateIsoCode) {
        this.stateIsoCode = stateIsoCode;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("country_iso_code")
    public String getCountryIsoCode() {
        return countryIsoCode;
    }

    @JsonProperty("country_iso_code")
    public void setCountryIsoCode(String countryIsoCode) {
        this.countryIsoCode = countryIsoCode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(LocationDetails.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("formattedAddress");
        sb.append('=');
        sb.append(((this.formattedAddress == null)?"<null>":this.formattedAddress));
        sb.append(',');
        sb.append("latitude");
        sb.append('=');
        sb.append(((this.latitude == null)?"<null>":this.latitude));
        sb.append(',');
        sb.append("longitude");
        sb.append('=');
        sb.append(((this.longitude == null)?"<null>":this.longitude));
        sb.append(',');
        sb.append("city");
        sb.append('=');
        sb.append(((this.city == null)?"<null>":this.city));
        sb.append(',');
        sb.append("state");
        sb.append('=');
        sb.append(((this.state == null)?"<null>":this.state));
        sb.append(',');
        sb.append("neighborhood");
        sb.append('=');
        sb.append(((this.neighborhood == null)?"<null>":this.neighborhood));
        sb.append(',');
        sb.append("subLocality");
        sb.append('=');
        sb.append(((this.subLocality == null)?"<null>":this.subLocality));
        sb.append(',');
        sb.append("stateIsoCode");
        sb.append('=');
        sb.append(((this.stateIsoCode == null)?"<null>":this.stateIsoCode));
        sb.append(',');
        sb.append("country");
        sb.append('=');
        sb.append(((this.country == null)?"<null>":this.country));
        sb.append(',');
        sb.append("countryIsoCode");
        sb.append('=');
        sb.append(((this.countryIsoCode == null)?"<null>":this.countryIsoCode));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
