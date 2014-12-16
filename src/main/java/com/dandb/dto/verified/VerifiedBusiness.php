<?php

namespace models\json;

use errors\VerificationErrors;
use exceptions\HaltException;
use lib\DANDB\Common;
use models\VerifiedHelper;
use enums\VerifiedType;
use enums\VerifiedStatusEnum;

class VerifiedBusiness extends JSONObject{

    public $_index;
    public $_type;
    public $_id;
    public $_version;
    public $_score;
    public $_source;
    private $creditCardVerification = false;

    public function __construct($json){
        if($json){
            $this->_source = BusinessSource::initForV1();
        } else {
            $this->_source = new BusinessSource();
        }
        parent::__construct($json, $this);
    }

    public static function initFromSproc($result, $enterpriseBusinessId, $showUser)
    {
        $source = Common::deepenFlatArray($result, '.');
        if(!$showUser){
            unset($source['user']);
        }
        $data['_source'] = $source;
        $data['_id'] = $enterpriseBusinessId;
        $verifiedBusiness = new VerifiedBusiness(false);
        $verifiedBusiness->set($data, $verifiedBusiness);
        return $verifiedBusiness;
    }

    public function getVerification($verificationType)
    {
        switch ($verificationType) {
            case VerifiedType::PHONE:
                $verificationArray =  $this->getPhoneVerification();
                $verificationArray['verification_status'] = $this->getPhoneVerificationStatus();
                break;
            case VerifiedType::EMAIL:
                $verificationArray = $this->getEmailVerification();
                $verificationArray['verification_status'] = $this->getEmailVerificationStatus();
                break;
            case VerifiedType::ADDRESS:
                $verificationArray = $this->getAddressVerification();
                $verificationArray['user_identifier'] = $this->getUserIdentifier();
                break;
            default:
                throw new HaltException(403, VerificationErrors::VERIFIED_INCORRECT_TYPE());
        }
        return $this->validateVerification($verificationArray);
    }

    private function validateVerification($verificationArray)
    {
        if ($verificationArray['code'] == null
            || $verificationArray['timestamp'] == null
            || $verificationArray['timestamp'] < VerifiedHelper::generateCreatedDate()
        ) {
            throw new HaltException(403, VerificationErrors::VERIFIED_EXISTING_RECORD_NOT_FOUND());
        }
        return $verificationArray;
    }

    private function createVerificationArray($code, $timestamp, $duns, $userId)
    {
        return array(
            'code' => $code,
            'timestamp' => $timestamp,
            'duns' => $duns,
            'user_identifier' => $userId,
            'enterprise_business_id' => $this->_id,
        );
    }

    public function getPhoneVerification()
    {
        return $this->createVerificationArray(
            isset($this->_source->user->phone_code) ? $this->_source->user->phone_code : null,
            isset($this->_source->user->phone_expiration) ? $this->_source->user->phone_expiration : null,
            $this->getDuns(),
            $this->getUserIdentifier()
        );
    }

    public function getEmailVerification()
    {
        return $this->createVerificationArray(
            isset($this->_source->user->email_code) ? $this->_source->user->email_code : null,
            isset($this->_source->user->email_expiration) ? $this->_source->user->email_expiration : null,
            $this->getDuns(),
            $this->getUserIdentifier()
        );
    }

    public function getAddressVerification()
    {
        return $this->createVerificationArray(
            isset($this->_source->user->address_code) ? $this->_source->user->address_code : null,
            isset($this->_source->user->address_expiration) ? $this->_source->user->address_expiration : null,
            $this->getDuns(),
            $this->getUserIdentifier()
        );
    }

    public function getUserIdentifier()
    {
        return isset($this->_source->user->user_identifier)
            ? $this->_source->user->user_identifier : null;
    }

    public function getAddressVerificationStatus()
    {
        return isset($this->_source->address->address_line_1->verification_status) ?
            $this->_source->address->address_line_1->verification_status : null;
    }

    public function getEmailVerificationStatus()
    {
        return isset($this->_source->business->email_address->verification_status) ?
            $this->_source->business->email_address->verification_status : null;
    }

    public function getPhoneVerificationStatus()
    {
        return isset($this->_source->business->phone->local_phone->verification_status) ?
            $this->_source->business->phone->local_phone->verification_status : null;
    }

    public function getWebsiteVerificationStatus()
    {
        return isset($this->_source->business->website->verification_status) ?
            $this->_source->business->website->verification_status : null;
    }

    public function getCCVerificationStatus()
    {
        return isset($this->_source->business->credit_card_verification_status->verification_status) ?
            $this->_source->business->credit_card_verification_status->verification_status : null;
    }

    public function getAddressVerifiedValue()
    {
        return isset($this->_source->address->address_line_1) ?
            $this->_source->address->address_line_1 : null;
    }

    public function getEmailVerifiedValue()
    {
        return isset($this->_source->business->email_address) ?
            $this->_source->business->email_address : null;
    }

    public function getPhoneVerifiedValue()
    {
        return isset($this->_source->business->phone->local_phone) ?
            $this->_source->business->phone->local_phone : null;
    }

    public function getWebsiteVerifiedValue()
    {
        return isset($this->_source->business->website) ?
            $this->_source->business->website : null;
    }

    public function getCCVerifiedValue()
    {
        return isset($this->_source->business->credit_card_verification_status) ?
            $this->_source->business->credit_card_verification_status : null;
    }

    public function getEmail()
    {
        return isset($this->_source->business->email_address->value) ?
            $this->_source->business->email_address->value : null;
    }
    public function getPhoneNumber()
    {
        return isset($this->_source->business->phone->local_phone->value) ?
            $this->_source->business->phone->local_phone->value : null;
    }
    public function setPhoneNumber($phoneNumber)
    {
        if (isset($this->_source->business->phone->local_phone)) {
            $this->_source->business->phone->local_phone->value = $phoneNumber;
        }
    }

    public function getCompanyName()
    {
        return isset($this->_source->company_name->value)
            ? $this->_source->company_name->value : null;
    }

    public function getAddressLine1()
    {
        return isset($this->_source->address->address_line_1->value)
            ? $this->_source->address->address_line_1->value : null;
    }

    public function getAddressLine2()
    {
        return isset($this->_source->address->address_line_2->value)
            ? $this->_source->address->address_line_2->value : " ";
    }

    public function getCity()
    {
        return isset($this->_source->address->city->value)
            ? $this->_source->address->city->value : null;
    }

    public function setCity($city)
    {
        $this->_source->address->city->value = $city;
    }

    public function getCountry()
    {
        return isset($this->_source->address->country->value)
            ? $this->_source->address->country->value : null;
    }

    public function getState()
    {
        return isset($this->_source->address->state->value)
            ? $this->_source->address->state->value : null;
    }

    public function getZip()
    {
        return isset($this->_source->address->postal_code->value)
            ? $this->_source->address->postal_code->value : null;
    }

    public function getDuns()
    {
        return isset($this->_source->_duns_number)
            ? Common::trimDunsNumber($this->_source->_duns_number) : null;
    }

    public function getDBA()
    {
        return isset($this->_source->DBA_Name->value)
            ? $this->_source->DBA_Name->value : null;
    }

    public function getWebsite()
    {
        return isset($this->_source->business->website->value)
            ? $this->_source->business->website->value : null;
    }

    public function getRequiredWebsite()
    {
        if(isset($this->_source->business->website->value)){
            return $this->_source->business->website->value;
        }
        throw new HaltException(403, VerificationErrors::VERIFIED_PROFILE_DOES_NOT_CONTAIN_WEBSITE());
    }

    public function getYearEstablished()
    {
        return isset($this->_source->business->year_established->value)
            ? $this->_source->business->year_established->value : null;
    }

    public function hasDuns()
    {
        return isset($this->_source->_duns_number);
    }

    public function hasState()
    {
        return isset($this->_source->address->state->value) && !empty($this->_source->address->state->value);
    }

    public function isPaid()
    {
        return isset($this->_source->business->localeze->publish_to_localeze->value) ? $this->_source->business->localeze->publish_to_localeze->value == 1 : false;
    }

    public function setPaid($isPaid)
    {
        $this->_source->business->localeze->publish_to_localeze->value = $isPaid;
    }

    public function isVeteranOwned()
    {
        return isset($this->_source->business->veteran_business_owner)
            ? $this->_source->business->veteran_business_owner : false;
    }

    public function isMinorityOwned()
    {
        return isset($this->_source->business->minority_business_owner)
            ? $this->_source->business->minority_business_owner : false;
    }

    public function isFemaleOwned()
    {
        return isset($this->_source->business->female_business_owner)
            ? $this->_source->business->female_business_owner : false;
    }

    public function isTransparentBadge()
    {
        return isset($this->_source->business->verified->transparent_badge)
            ? $this->_source->business->verified->transparent_badge : false;
    }

    public function isVisibleBadge()
    {
        return isset($this->_source->business->verified->visible_badge)
            ? $this->_source->business->verified->visible_badge : false;
    }

    public function getVerifiedBadgeTypeMask()
    {
        return isset($this->_source->business->verified) && $this->_source->business->verified instanceof Verified
            ? $this->_source->business->verified->get_verified_badge_type_mask()
            : 0;
    }

    public function getDoNotSearchIndicator()
    {
        return isset($this->_source->do_not_search_indicator) ? $this->_source->do_not_search_indicator : false;
    }

    public function setAddressVerificationStatus($newStatus)
    {
        if (isset($this->_source->address->address_line_1)) {
            $this->_source->address->address_line_1->verification_status = $newStatus;
        }
    }

    public function setAddress($requestData)
    {
        if (isset($this->_source->address->address_line_1)) {
            $this->_source->address->address_line_1->value = Common::valueOrHalt($requestData, 'address_line_1');
        }
        if (isset($this->_source->address->address_line_2)) {
            $this->_source->address->address_line_2->value = Common::valueOr($requestData, 'address_line_2');
        }
        if (isset($this->_source->address->city)) {
            $this->_source->address->city->value = Common::valueOrHalt($requestData, 'city');
        }
        if (isset($this->_source->address->state)) {
            $this->_source->address->state->value = Common::valueOrHalt($requestData, 'state');
        }
        if (isset($this->_source->address->postal_code)) {
            $this->_source->address->postal_code->value = Common::valueOrHalt($requestData, 'zip');
        }
    }

    public function setEmail($email)
    {
        if (isset($this->_source->business->email_address)) {
            $this->_source->business->email_address->value = $email;
        }
    }

    public function assertNotVerified(){
        if($this->determineProfileState() === VerifiedStatusEnum::VERIFIED){
            throw new HaltException(403, VerificationErrors::VERIFIED_BUSINESS_ALREADY_VERIFIED());
        }
    }

    public function isProfileVerified()
    {
        $verificationStatuses = array(
            VerifiedType::ADDRESS => $this->getAddressVerificationStatus(),
            VerifiedType::EMAIL => $this->getEmailVerificationStatus(),
            VerifiedType::WEB => $this->getWebsiteVerificationStatus(),
            VerifiedType::CC => $this->getCCVerificationStatus(),
            VerifiedType::PHONE => $this->getPhoneVerificationStatus(),
        );

        //If ONE of the elements are VERIFIED, then the profile is Verified.
        return in_array(VerifiedStatusEnum::VERIFIED, $verificationStatuses);
    }

    public function determineProfileState()
    {
        $verificationStatuses = array(
            VerifiedType::ADDRESS => $this->getAddressVerificationStatus(),
            VerifiedType::EMAIL => $this->getEmailVerificationStatus(),
            VerifiedType::WEB => $this->getWebsiteVerificationStatus(),
            VerifiedType::CC => $this->getCCVerificationStatus(),
            VerifiedType::PHONE => $this->getPhoneVerificationStatus(),
        );

        //If ONE of the elements are VERIFIED, then the profile is Verified.
        if (in_array(VerifiedStatusEnum::VERIFIED, $verificationStatuses)) {
            return VerifiedStatusEnum::VERIFIED;
        }

        //If ALL the elements are Unverified, then the profile is Unverified.
        if (count(array_unique($verificationStatuses)) == 1
            && in_array(VerifiedStatusEnum::UNVERIFIED, $verificationStatuses)
        ) {
            return VerifiedStatusEnum::UNVERIFIED;
        }

        /**
         * Check each individual element for Pending state, if the element is in Pending state,
         * check when the code of the element expires.
         */
        $verificationArrays = array(VerifiedType::ADDRESS => $this->getAddressVerification(),
            VerifiedType::PHONE => $this->getPhoneVerification(),
            VerifiedType::EMAIL => $this->getEmailVerification()
        );

        foreach ($verificationArrays as $key => $value) {
            if ($verificationStatuses[$key] == VerifiedStatusEnum::PENDING &&
                $value['timestamp'] > date("Y-m-d H:i:s")
            ) {
                return VerifiedStatusEnum::PENDING;
            }
        }
        return VerifiedStatusEnum::UNVERIFIED;
    }

    public function getVerifiedSinceDate()
    {
        $verifiedValues = array(
            $this->getAddressVerifiedValue(),
            $this->getEmailVerifiedValue(),
            $this->getPhoneVerifiedValue(),
            $this->getWebsiteVerifiedValue(),
            $this->getCCVerifiedValue()
        );
        $verifiedSince = date("Y-m-d H:i:s");
        foreach ($verifiedValues as $verifiedValue)
        {
            if ($verifiedValue->verification_status == VerifiedStatusEnum::VERIFIED) {
                if ($verifiedValue->verification_timestamp < $verifiedSince) {
                    $verifiedSince = $verifiedValue->verification_timestamp;
                }
            }
        }
        return $verifiedSince;
    }

    public function isAddressVerificationUnverified()
    {
        return strcmp($this->getAddressVerificationStatus(), VerifiedStatusEnum::UNVERIFIED) === 0;
    }
}
