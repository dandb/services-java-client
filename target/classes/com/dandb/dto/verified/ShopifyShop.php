<?php

namespace models\json;

class ShopifyShop extends JSONObject
{
    /** @var Shop */
    public $shop;

    function __construct($json = false, $object = false)
    {
        $this->shop = new Shop($json);
        parent::__construct($json, $object);
    }
} 