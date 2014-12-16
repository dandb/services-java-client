package com.dandb.dto.verified;

class Verification {

    /** @var ServiceProvidedVerification */
    public $owner;
    /** @var ServiceProvidedVerification */
    public $veteran;
    public $declaration_timestamp;
    public $declaration_error_message;

    function __construct($json = false, $object = false)
    {
        $this->owner = new ServiceProvidedVerification();
        $this->veteran = new ServiceProvidedVerification();
        parent::__construct($json, $object);
    }

    private function bothNamesMatch()
    {
        return $this->namesMatch($this->owner->first_name, $this->veteran->first_name)
            && $this->namesMatch($this->owner->last_name, $this->veteran->last_name);
    }
    private function namesMatch($name1, $name2)
    {
        return $this->cleanName($name1) == $this->cleanName($name2);
    }

    private function cleanName($name)
    {
        return strtolower(preg_replace('/[^a-zA-Z0-9]/', '', $name));
    }

    public function businessRules(){
        if($this->veteran->complete && $this->owner->complete){
            if ($this->bothNamesMatch()) {
                return;
            } else {
                $this->declaration_error_message = VerificationErrors::VETERAN_NAMES_DO_NOT_MATCH()->errorMessage;
            }
        }
    }


} 