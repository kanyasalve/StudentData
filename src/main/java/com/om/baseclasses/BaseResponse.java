package com.om.baseclasses;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Setter;
import lombok.ToString;

import java.util.Collection;


@JsonInclude(JsonInclude.Include.NON_EMPTY)
@ToString
@Setter
public class BaseResponse {

    @JsonProperty("oBody")
    private Payload<?> payload;

    @JsonProperty("oStatus")
    private Status status;

    @JsonProperty("aError")
    private Collection<Errors> errors;


    public static Builder builder() {
        return new Builder();
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


    public void setPayload(Payload<?> payload) {
        this.payload = payload;
    }


    public Collection<Errors> getErrors() {
        return errors;
    }

    public void setErrors(Collection<Errors> errors) {
        this.errors = errors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseResponse that = (BaseResponse) o;

        if (payload != null ? !payload.equals(that.payload) : that.payload != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        return !(errors != null ? !errors.equals(that.errors) : that.errors != null);

    }

    @Override
    public int hashCode() {
        int result = payload != null ? payload.hashCode() : 0;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (errors != null ? errors.hashCode() : 0);
        return result;
    }

    public void setMessage(String s) {
    }


    public static class Builder {
        private BaseResponse baseResponse = new BaseResponse();

        public BaseResponse build() {
            return this.baseResponse;
        }

        public Builder payload(Payload<?> payload) {
            this.baseResponse.setPayload(payload);
            return this;
        }

        public Builder errors(Collection<Errors> errors) {
            this.baseResponse.setErrors(errors);
            return this;
        }

        public Builder status(Status status) {
            this.baseResponse.setStatus(status);
            return this;
        }
    }
}




