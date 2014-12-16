<?php

namespace models\json;


class Shop extends JSONObject
{
    public $address1;
    public $city;
    public $country;
    public $created_at;
    public $customer_email;
    public $domain;
    public $email;
    public $id;
    public $latitude;
    public $longitude;
    public $name;
    public $phone;
    public $primary_location_id;
    public $province;
    public $public;
    public $source;
    public $zip;
    public $country_code;
    public $country_name;
    public $currency;
    public $timezone;
    public $shop_owner;
    public $money_format;
    public $money_with_currency_format;
    public $province_code;
    public $taxes_included;
    public $tax_shipping;
    public $county_taxes;
    public $plan_display_name;
    public $plan_name;
    public $myshopify_domain;
    public $google_apps_domain;
    public $google_apps_login_enabled;
    public $money_in_emails_format;
    public $money_with_currency_in_emails_format;
    public $eligible_for_payments;
    public $requires_extra_payments_agreement;
    public $password_enabled;
    public $has_storefront;

    function __construct($json = false, $object = false)
    {
        parent::__construct($json, $object);
    }
}