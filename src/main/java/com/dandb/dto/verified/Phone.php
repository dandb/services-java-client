<?php

namespace models\json;

class Phone extends JSONObject{

    /** @var VerifiedValue */
    public $fax;
    /** @var VerifiedValue */
    public $toll_free_number;
    /** @var VerifiedValue */
    public $local_phone;

    function __construct()
    {
        $this->fax = new VerifiedValue();
        $this->local_phone = new VerifiedValue();
        $this->toll_free_number = new VerifiedValue();
    }


}