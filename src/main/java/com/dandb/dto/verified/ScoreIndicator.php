<?php

namespace models\json;


class ScoreIndicator extends JSONObject{

    /** @var VerifiedValue */
    public $credibility;
    /** @var VerifiedValue */
    public $paydex;
    /** @var VerifiedValue */
    public $predictor;
    /** @var VerifiedValue */
    public $risk_rating;
    /** @var VerifiedValue */
    public $stress;

    function __construct()
    {
        $this->credibility = new VerifiedValue();
        $this->paydex = new VerifiedValue();
        $this->predictor = new VerifiedValue();
        $this->risk_rating = new VerifiedValue();
        $this->stress = new VerifiedValue();
    }


}