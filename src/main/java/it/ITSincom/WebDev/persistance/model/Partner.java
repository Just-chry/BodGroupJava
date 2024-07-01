package it.ITSincom.WebDev.persistance.model;

import java.time.LocalDate;

public class Partner {
    private String partnerCode;
    private String partnerName;
    private String contractCode;
    private String contractDescription;
    private LocalDate contractStart;
    private LocalDate contractEnd;
    private double finalPriceExcludingVAT;
    private String productCode;
    private String productName;
    private LocalDate time;

    public String getPartnerCode() {
        return partnerCode;
    }

    public void setPartnerCode(String partnerCode) {
        this.partnerCode = partnerCode;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public String getContractDescription() {
        return contractDescription;
    }

    public void setContractDescription(String contractDescription) {
        this.contractDescription = contractDescription;
    }

    public LocalDate getContractStart() {
        return contractStart;
    }

    public void setContractStart(LocalDate contractStart) {
        this.contractStart = contractStart;
    }

    public LocalDate getContractEnd() {
        return contractEnd;
    }

    public void setContractEnd(LocalDate contractEnd) {
        this.contractEnd = contractEnd;
    }

    public double getFinalPriceExcludingVAT() {
        return finalPriceExcludingVAT;
    }

    public void setFinalPriceExcludingVAT(double finalPriceExcludingVAT) {
        this.finalPriceExcludingVAT = finalPriceExcludingVAT;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public LocalDate getTime() {
        return time;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }
}