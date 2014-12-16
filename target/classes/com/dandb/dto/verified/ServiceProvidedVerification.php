<?php

namespace models\json;

class ServiceProvidedVerification extends JSONObject{

    const COMPLETE_REQUEST_STATUS = 'COMPLETE';

    public $service_provider_request_id;
    public $service_provider_verification_status;
    public $service_provider_request_status;
    public $service_provider_request_timestamp;
    public $first_name;
    public $last_name;
    public $complete = false;

    function __construct($json = false, $object = false)
    {
        parent::__construct($json, $object);
    }

    public function businessRules()
    {
        $this->complete = filter_var($this->service_provider_verification_status, FILTER_VALIDATE_BOOLEAN) === true
            && $this->service_provider_request_status == self::COMPLETE_REQUEST_STATUS;
    }

}