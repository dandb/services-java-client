<?php

namespace models\json;


use lib\DANDB\Common;

class JSONObject {

    /**
     * @param bool $json
     * @param bool|JSONObject $object
     */
    public function __construct($json = false, $object = false) {
        if ($json) {
            $this->set(json_decode($json, true), $object);
        }
    }

    public function set($data, $object) {
        foreach ($data AS $key => $value) {
            if (is_array($value)) {
                if($object && property_exists($object,$key) && $object->$key){
                    $sub = $object->$key;
                } else {
                    $sub = new JSONObject();
                }
                $value = $sub->set($value, $sub);
                $sub->businessRules();
            }
            $setMethodName = $this->generateMethodName($key);
            if(method_exists($this, $setMethodName)){
                $this->$setMethodName($value);
            } else {
                $this->$key = $value;
            }
        }
        return $this;
    }

    private function generateMethodName($key){
        return 'set_' . $key;
    }

    public function businessRules(){
        //To be implemented by child class if necessary. Not abstract to cut down on unnecessary code.
    }

    function __get($name){
        return Common::objectValueOr($this, $name, null);
    }
}