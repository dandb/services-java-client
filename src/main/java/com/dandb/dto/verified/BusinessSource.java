package com.dandb.dto.verified;

import java.math.BigInteger;

class BusinessSource extends JSONObject{

    public String created_date;
    public VerifiedValue DBA_Name;
    public SIC SIC;
    public Address address;
    public VerifiedValue company_name;
    public Social social;
    public VerifiedValue Verification_status;
    public BigInteger _VerifyID;
    public NAICS NAICS;
    public Business business;
    public String _duns_number;
    public User user;
    /** @var Verification */
    public $verification;

    function __construct($json = false, $object = false)
    {
        $this->business = new Business();
        $this->verification = new Verification();
        parent::__construct($json, $object);
    }

    public static function initForV1()
    {
        $businessSource = new BusinessSource();
        $businessSource->DBA_Name = new VerifiedValue();
        $businessSource->SIC = new SIC();
        $businessSource->address = new Address();
        $businessSource->company_name = new VerifiedValue();
        $businessSource->social = new Social();
        $businessSource->Verification_status = new VerifiedValue();
        $businessSource->NAICS = new NAICS();
        $businessSource->business = new Business();
        $businessSource->user = new User();
        $businessSource->verification = new Verification();
        return $businessSource;
    }


}