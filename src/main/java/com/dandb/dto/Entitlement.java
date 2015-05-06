package com.dandb.dto;

public class Entitlement {
    private Product _product;
    private Business _business;
    
    public Product get_product() {
        return _product;
    }

    public void set_product(Product _product) {
        this._product = _product;
    }

    public Business get_business() {
        return _business;
    }

    public void set_business(Business _business) {
        this._business = _business;
    }   
}

class Product {

    private String _name;
    private String _catalogIdentifier;
    private String _catalogCode;
    private String _displayName;
    private String _groupCode;
    private String _typeCode;
    private String _tradeReferenceBaseProductItemIdentifier;
    private String _tradeReferenceRejected;
    private String _tradeReferenceOrdered;
    private String _tradeReferenceUtilized;
    private String _tradeReferencePending;
    private String _tradeReferenceAvailable;
    private String _tradeReferenceAccepted;
    private String _entitlementIdentifier;
    private String _productCategoryCode;
    private String _entitlementEndDate;
    private String _orderIdentifier;
    public String get_name() {
        return _name;
    }
    public void set_name(String _name) {
        this._name = _name;
    }
    public String get_catalogIdentifier() {
        return _catalogIdentifier;
    }
    public void set_catalogIdentifier(String _catalogIdentifier) {
        this._catalogIdentifier = _catalogIdentifier;
    }
    public String get_catalogCode() {
        return _catalogCode;
    }
    public void set_catalogCode(String _catalogCode) {
        this._catalogCode = _catalogCode;
    }
    public String get_displayName() {
        return _displayName;
    }
    public void set_displayName(String _displayName) {
        this._displayName = _displayName;
    }
    public String get_groupCode() {
        return _groupCode;
    }
    public void set_groupCode(String _groupCode) {
        this._groupCode = _groupCode;
    }
    public String get_typeCode() {
        return _typeCode;
    }
    public void set_typeCode(String _typeCode) {
        this._typeCode = _typeCode;
    }
    public String get_tradeReferenceBaseProductItemIdentifier() {
        return _tradeReferenceBaseProductItemIdentifier;
    }
    public void set_tradeReferenceBaseProductItemIdentifier(
            String _tradeReferenceBaseProductItemIdentifier) {
        this._tradeReferenceBaseProductItemIdentifier = _tradeReferenceBaseProductItemIdentifier;
    }
    public String get_tradeReferenceRejected() {
        return _tradeReferenceRejected;
    }
    public void set_tradeReferenceRejected(String _tradeReferenceRejected) {
        this._tradeReferenceRejected = _tradeReferenceRejected;
    }
    public String get_tradeReferenceOrdered() {
        return _tradeReferenceOrdered;
    }
    public void set_tradeReferenceOrdered(String _tradeReferenceOrdered) {
        this._tradeReferenceOrdered = _tradeReferenceOrdered;
    }
    public String get_tradeReferenceUtilized() {
        return _tradeReferenceUtilized;
    }
    public void set_tradeReferenceUtilized(String _tradeReferenceUtilized) {
        this._tradeReferenceUtilized = _tradeReferenceUtilized;
    }
    public String get_tradeReferencePending() {
        return _tradeReferencePending;
    }
    public void set_tradeReferencePending(String _tradeReferencePending) {
        this._tradeReferencePending = _tradeReferencePending;
    }
    public String get_tradeReferenceAvailable() {
        return _tradeReferenceAvailable;
    }
    public void set_tradeReferenceAvailable(String _tradeReferenceAvailable) {
        this._tradeReferenceAvailable = _tradeReferenceAvailable;
    }
    public String get_tradeReferenceAccepted() {
        return _tradeReferenceAccepted;
    }
    public void set_tradeReferenceAccepted(String _tradeReferenceAccepted) {
        this._tradeReferenceAccepted = _tradeReferenceAccepted;
    }
    public String get_entitlementIdentifier() {
        return _entitlementIdentifier;
    }
    public void set_entitlementIdentifier(String _entitlementIdentifier) {
        this._entitlementIdentifier = _entitlementIdentifier;
    }
    public String get_productCategoryCode() {
        return _productCategoryCode;
    }
    public void set_productCategoryCode(String _productCategoryCode) {
        this._productCategoryCode = _productCategoryCode;
    }
    public String get_entitlementEndDate() {
        return _entitlementEndDate;
    }
    public void set_entitlementEndDate(String _entitlementEndDate) {
        this._entitlementEndDate = _entitlementEndDate;
    }
    public String get_orderIdentifier() {
        return _orderIdentifier;
    }
    public void set_orderIdentifier(String _orderIdentifier) {
        this._orderIdentifier = _orderIdentifier;
    }
}

class Business {
    private String _duns;
    private String _name;
    private String _phoneNumber;
    private String _address;
    private String _addressExtended;
    private String _city;
    private String _state;
    private String _zip;
    private String _country;
    private String _businessId;
    private String _enterpriseBusinessId;
    private String _verified;
    private String _claimed;
    private String _credibilityReviewLink;
    private String _scores;
    private String _tradeReferences;
    private String _inquiries;
    private String _events;
    public String get_duns() {
        return _duns;
    }
    public void set_duns(String _duns) {
        this._duns = _duns;
    }
    public String get_name() {
        return _name;
    }
    public void set_name(String _name) {
        this._name = _name;
    }
    public String get_phoneNumber() {
        return _phoneNumber;
    }
    public void set_phoneNumber(String _phoneNumber) {
        this._phoneNumber = _phoneNumber;
    }
    public String get_address() {
        return _address;
    }
    public void set_address(String _address) {
        this._address = _address;
    }
    public String get_addressExtended() {
        return _addressExtended;
    }
    public void set_addressExtended(String _addressExtended) {
        this._addressExtended = _addressExtended;
    }
    public String get_city() {
        return _city;
    }
    public void set_city(String _city) {
        this._city = _city;
    }
    public String get_state() {
        return _state;
    }
    public void set_state(String _state) {
        this._state = _state;
    }
    public String get_zip() {
        return _zip;
    }
    public void set_zip(String _zip) {
        this._zip = _zip;
    }
    public String get_country() {
        return _country;
    }
    public void set_country(String _country) {
        this._country = _country;
    }
    public String get_businessId() {
        return _businessId;
    }
    public void set_businessId(String _businessId) {
        this._businessId = _businessId;
    }
    public String get_enterpriseBusinessId() {
        return _enterpriseBusinessId;
    }
    public void set_enterpriseBusinessId(String _enterpriseBusinessId) {
        this._enterpriseBusinessId = _enterpriseBusinessId;
    }
    public String get_verified() {
        return _verified;
    }
    public void set_verified(String _verified) {
        this._verified = _verified;
    }
    public String get_claimed() {
        return _claimed;
    }
    public void set_claimed(String _claimed) {
        this._claimed = _claimed;
    }
    public String get_credibilityReviewLink() {
        return _credibilityReviewLink;
    }
    public void set_credibilityReviewLink(String _credibilityReviewLink) {
        this._credibilityReviewLink = _credibilityReviewLink;
    }
    public String get_scores() {
        return _scores;
    }
    public void set_scores(String _scores) {
        this._scores = _scores;
    }
    public String get_tradeReferences() {
        return _tradeReferences;
    }
    public void set_tradeReferences(String _tradeReferences) {
        this._tradeReferences = _tradeReferences;
    }
    public String get_inquiries() {
        return _inquiries;
    }
    public void set_inquiries(String _inquiries) {
        this._inquiries = _inquiries;
    }
    public String get_events() {
        return _events;
    }
    public void set_events(String _events) {
        this._events = _events;
    }
}