<?php

namespace models\json;

class Hours_of_operation extends JSONObject{

    /** @var VerifiedValue */
    public $sunday_open;
    /** @var VerifiedValue */
    public $thursday_close;
    /** @var VerifiedValue */
    public $monday_close;
    /** @var VerifiedValue */
    public $tuesday_close;
    /** @var VerifiedValue */
    public $friday_open;
    /** @var VerifiedValue */
    public $sunday_close;
    /** @var VerifiedValue */
    public $tuesday_open;
    /** @var VerifiedValue */
    public $monday_open;
    /** @var VerifiedValue */
    public $saturday_open;
    /** @var VerifiedValue */
    public $thursday_open;
    /** @var VerifiedValue */
    public $wednesday_close;
    /** @var VerifiedValue */
    public $friday_close;
    /** @var VerifiedValue */
    public $saturday_close;
    /** @var VerifiedValue */
    public $wednesday_open;

    function __construct()
    {
        $this->friday_close = new VerifiedValue();
        $this->friday_open = new VerifiedValue();
        $this->monday_close = new VerifiedValue();
        $this->monday_open = new VerifiedValue();
        $this->saturday_close = new VerifiedValue();
        $this->saturday_open = new VerifiedValue();
        $this->sunday_close = new VerifiedValue();
        $this->sunday_open = new VerifiedValue();
        $this->thursday_close = new VerifiedValue();
        $this->thursday_open = new VerifiedValue();
        $this->tuesday_close = new VerifiedValue();
        $this->tuesday_open = new VerifiedValue();
        $this->wednesday_close = new VerifiedValue();
        $this->wednesday_open = new VerifiedValue();
    }


}