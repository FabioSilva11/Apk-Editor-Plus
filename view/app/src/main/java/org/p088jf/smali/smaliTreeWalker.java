package org.p088jf.smali;

import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v7.appcompat.C0299R;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import org.antlr.runtime.BitSet;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.TreeNodeStream;
import org.antlr.runtime.tree.TreeParser;
import org.antlr.runtime.tree.TreeRuleReturnScope;
import org.p088jf.dexlib2.AccessFlags;
import org.p088jf.dexlib2.AnnotationVisibility;
import org.p088jf.dexlib2.HiddenApiRestriction;
import org.p088jf.dexlib2.MethodHandleType;
import org.p088jf.dexlib2.Opcode;
import org.p088jf.dexlib2.Opcodes;
import org.p088jf.dexlib2.VerificationError;
import org.p088jf.dexlib2.builder.Label;
import org.p088jf.dexlib2.builder.MethodImplementationBuilder;
import org.p088jf.dexlib2.builder.SwitchLabelElement;
import org.p088jf.dexlib2.builder.instruction.BuilderArrayPayload;
import org.p088jf.dexlib2.builder.instruction.BuilderInstruction10t;
import org.p088jf.dexlib2.builder.instruction.BuilderInstruction10x;
import org.p088jf.dexlib2.builder.instruction.BuilderInstruction11n;
import org.p088jf.dexlib2.builder.instruction.BuilderInstruction11x;
import org.p088jf.dexlib2.builder.instruction.BuilderInstruction12x;
import org.p088jf.dexlib2.builder.instruction.BuilderInstruction20bc;
import org.p088jf.dexlib2.builder.instruction.BuilderInstruction20t;
import org.p088jf.dexlib2.builder.instruction.BuilderInstruction21c;
import org.p088jf.dexlib2.builder.instruction.BuilderInstruction21ih;
import org.p088jf.dexlib2.builder.instruction.BuilderInstruction21lh;
import org.p088jf.dexlib2.builder.instruction.BuilderInstruction21s;
import org.p088jf.dexlib2.builder.instruction.BuilderInstruction21t;
import org.p088jf.dexlib2.builder.instruction.BuilderInstruction22b;
import org.p088jf.dexlib2.builder.instruction.BuilderInstruction22c;
import org.p088jf.dexlib2.builder.instruction.BuilderInstruction22s;
import org.p088jf.dexlib2.builder.instruction.BuilderInstruction22t;
import org.p088jf.dexlib2.builder.instruction.BuilderInstruction22x;
import org.p088jf.dexlib2.builder.instruction.BuilderInstruction23x;
import org.p088jf.dexlib2.builder.instruction.BuilderInstruction30t;
import org.p088jf.dexlib2.builder.instruction.BuilderInstruction31c;
import org.p088jf.dexlib2.builder.instruction.BuilderInstruction31i;
import org.p088jf.dexlib2.builder.instruction.BuilderInstruction31t;
import org.p088jf.dexlib2.builder.instruction.BuilderInstruction32x;
import org.p088jf.dexlib2.builder.instruction.BuilderInstruction35c;
import org.p088jf.dexlib2.builder.instruction.BuilderInstruction3rc;
import org.p088jf.dexlib2.builder.instruction.BuilderInstruction45cc;
import org.p088jf.dexlib2.builder.instruction.BuilderInstruction4rcc;
import org.p088jf.dexlib2.builder.instruction.BuilderInstruction51l;
import org.p088jf.dexlib2.builder.instruction.BuilderPackedSwitchPayload;
import org.p088jf.dexlib2.builder.instruction.BuilderSparseSwitchPayload;
import org.p088jf.dexlib2.iface.Annotation;
import org.p088jf.dexlib2.iface.AnnotationElement;
import org.p088jf.dexlib2.iface.ClassDef;
import org.p088jf.dexlib2.iface.value.EncodedValue;
import org.p088jf.dexlib2.immutable.ImmutableAnnotation;
import org.p088jf.dexlib2.immutable.ImmutableAnnotationElement;
import org.p088jf.dexlib2.immutable.reference.ImmutableCallSiteReference;
import org.p088jf.dexlib2.immutable.reference.ImmutableFieldReference;
import org.p088jf.dexlib2.immutable.reference.ImmutableMethodHandleReference;
import org.p088jf.dexlib2.immutable.reference.ImmutableMethodProtoReference;
import org.p088jf.dexlib2.immutable.reference.ImmutableMethodReference;
import org.p088jf.dexlib2.immutable.reference.ImmutableReference;
import org.p088jf.dexlib2.immutable.reference.ImmutableTypeReference;
import org.p088jf.dexlib2.immutable.value.ImmutableEncodedValue;
import org.p088jf.dexlib2.writer.builder.BuilderField;
import org.p088jf.dexlib2.writer.builder.BuilderMethod;
import org.p088jf.dexlib2.writer.builder.DexBuilder;
import org.p088jf.util.LinearSearch;

/* JADX INFO: loaded from: classes.dex */
public class smaliTreeWalker extends TreeParser {
    public static final BitSet FOLLOW_ANNOTATION_VISIBILITY_in_annotation3996;
    public static final BitSet FOLLOW_ARRAY_TYPE_PREFIX_in_array_descriptor3548;
    public static final BitSet FOLLOW_BOOL_LITERAL_in_bool_literal3912;
    public static final BitSet FOLLOW_BYTE_LITERAL_in_byte_literal3833;
    public static final BitSet FOLLOW_CHAR_LITERAL_in_char_literal3878;
    public static final BitSet FOLLOW_CLASS_DESCRIPTOR_in_array_descriptor3580;
    public static final BitSet FOLLOW_CLASS_DESCRIPTOR_in_nonvoid_type_descriptor3606;
    public static final BitSet FOLLOW_CLASS_DESCRIPTOR_in_reference_type_descriptor3635;
    public static final BitSet FOLLOW_CLASS_DESCRIPTOR_in_subannotation4060;
    public static final BitSet FOLLOW_CLASS_DESCRIPTOR_in_verification_error_reference2005;
    public static final BitSet FOLLOW_DOUBLE_LITERAL_in_double_literal3863;
    public static final BitSet FOLLOW_FLOAT_LITERAL_in_float_literal3848;
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT10t_in_insn_format10t2316;
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT10x_in_insn_format10x2343;
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT11n_in_insn_format11n2368;
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT11x_in_insn_format11x2397;
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT12x_in_insn_format12x2424;
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT20bc_in_insn_format20bc2457;
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT20t_in_insn_format20t2486;

    /* JADX INFO: renamed from: FOLLOW_INSTRUCTION_FORMAT21c_METHOD_HANDLE_in_insn_format21c_method_handle2553 */
    public static final BitSet f4797x8b66dd46;

    /* JADX INFO: renamed from: FOLLOW_INSTRUCTION_FORMAT21c_METHOD_TYPE_in_insn_format21c_method_type2586 */
    public static final BitSet f4798xcbb198ca;
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT21c_STRING_in_insn_format21c_string2616;
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT21c_TYPE_in_insn_format21c_type2645;
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT21ih_in_insn_format21ih2674;
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT21lh_in_insn_format21lh2703;
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT21s_in_insn_format21s2732;
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT21t_in_insn_format21t2761;
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT22b_in_insn_format22b2790;
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT22c_TYPE_in_insn_format22c_type2868;
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT22s_in_insn_format22s2903;
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT22t_in_insn_format22t2938;
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT22x_in_insn_format22x2973;
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT23x_in_insn_format23x3006;
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT30t_in_insn_format30t3043;
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT31c_in_insn_format31c3070;
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT31i_in_insn_format31i3099;
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT31t_in_insn_format31t3128;
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT32x_in_insn_format32x3157;

    /* JADX INFO: renamed from: FOLLOW_INSTRUCTION_FORMAT35c_CALL_SITE_in_insn_format35c_call_site3195 */
    public static final BitSet f4799x5961a91d;
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT35c_METHOD_in_insn_format35c_method3224;
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT35c_TYPE_in_insn_format35c_type3253;

    /* JADX INFO: renamed from: FOLLOW_INSTRUCTION_FORMAT3rc_CALL_SITE_in_insn_format3rc_call_site3287 */
    public static final BitSet f4800x8b78a687;
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT3rc_METHOD_in_insn_format3rc_method3316;
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT3rc_TYPE_in_insn_format3rc_type3345;

    /* JADX INFO: renamed from: FOLLOW_INSTRUCTION_FORMAT45cc_METHOD_in_insn_format45cc_method3374 */
    public static final BitSet f4801xfe79ac4a;

    /* JADX INFO: renamed from: FOLLOW_INSTRUCTION_FORMAT4rcc_METHOD_in_insn_format4rcc_method3405 */
    public static final BitSet f4802x92751f39;
    public static final BitSet FOLLOW_INSTRUCTION_FORMAT51l_in_insn_format51l_type3436;
    public static final BitSet FOLLOW_INTEGER_LITERAL_in_integer_literal3788;
    public static final BitSet FOLLOW_I_ANNOTATIONS_in_annotations3962;
    public static final BitSet FOLLOW_I_ANNOTATION_ELEMENT_in_annotation_element4019;
    public static final BitSet FOLLOW_I_ANNOTATION_in_annotation3994;
    public static final BitSet FOLLOW_I_ARRAY_ELEMENT_SIZE_in_insn_array_data_directive3466;

    /* JADX INFO: renamed from: FOLLOW_I_CALL_SITE_EXTRA_ARGUMENTS_in_call_site_extra_arguments1868 */
    public static final BitSet f4804xd2a85fb2;
    public static final BitSet FOLLOW_I_CATCHALL_in_catchall_directive1588;
    public static final BitSet FOLLOW_I_CATCHES_in_catches1540;
    public static final BitSet FOLLOW_I_CATCH_in_catch_directive1558;
    public static final BitSet FOLLOW_I_ENCODED_ARRAY_in_array_literal3934;
    public static final BitSet FOLLOW_I_ENCODED_ENUM_in_enum_literal4156;
    public static final BitSet FOLLOW_I_ENCODED_FIELD_in_field_literal4110;
    public static final BitSet FOLLOW_I_ENCODED_METHOD_HANDLE_in_method_handle_literal1391;
    public static final BitSet FOLLOW_I_ENCODED_METHOD_in_method_literal4133;
    public static final BitSet FOLLOW_I_END_LOCAL_in_end_local1768;
    public static final BitSet FOLLOW_I_EPILOGUE_in_epilogue1823;
    public static final BitSet FOLLOW_I_LABEL_in_label_def1512;
    public static final BitSet FOLLOW_I_LINE_in_line1707;
    public static final BitSet FOLLOW_I_LOCALS_in_registers_directive1474;
    public static final BitSet FOLLOW_I_LOCAL_in_local1727;
    public static final BitSet FOLLOW_I_ORDERED_METHOD_ITEMS_in_ordered_method_items1887;

    /* JADX INFO: renamed from: FOLLOW_I_PACKED_SWITCH_START_KEY_in_insn_packed_switch_directive3496 */
    public static final BitSet f4805x4c89fb9f;
    public static final BitSet FOLLOW_I_PARAMETERS_in_parameters1617;
    public static final BitSet FOLLOW_I_PARAMETER_in_parameter1636;
    public static final BitSet FOLLOW_I_PROLOGUE_in_prologue1807;
    public static final BitSet FOLLOW_I_REGISTERS_in_registers_directive1462;
    public static final BitSet FOLLOW_I_REGISTER_LIST_in_register_list1939;
    public static final BitSet FOLLOW_I_REGISTER_RANGE_in_register_range1973;
    public static final BitSet FOLLOW_I_RESTART_LOCAL_in_restart_local1788;
    public static final BitSet FOLLOW_I_SOURCE_in_source1840;
    public static final BitSet FOLLOW_I_STATEMENT_ARRAY_DATA_in_insn_array_data_directive3463;
    public static final BitSet FOLLOW_I_STATEMENT_FORMAT10t_in_insn_format10t2314;
    public static final BitSet FOLLOW_I_STATEMENT_FORMAT10x_in_insn_format10x2341;
    public static final BitSet FOLLOW_I_STATEMENT_FORMAT11n_in_insn_format11n2366;
    public static final BitSet FOLLOW_I_STATEMENT_FORMAT11x_in_insn_format11x2395;
    public static final BitSet FOLLOW_I_STATEMENT_FORMAT12x_in_insn_format12x2422;
    public static final BitSet FOLLOW_I_STATEMENT_FORMAT20bc_in_insn_format20bc2455;
    public static final BitSet FOLLOW_I_STATEMENT_FORMAT20t_in_insn_format20t2484;
    public static final BitSet FOLLOW_I_STATEMENT_FORMAT21c_FIELD_in_insn_format21c_field2511;

    /* JADX INFO: renamed from: FOLLOW_I_STATEMENT_FORMAT21c_METHOD_HANDLE_in_insn_format21c_method_handle2548 */
    public static final BitSet f4806x73619f17;

    /* JADX INFO: renamed from: FOLLOW_I_STATEMENT_FORMAT21c_METHOD_TYPE_in_insn_format21c_method_type2581 */
    public static final BitSet f4807x74980830;
    public static final BitSet FOLLOW_I_STATEMENT_FORMAT21c_STRING_in_insn_format21c_string2614;
    public static final BitSet FOLLOW_I_STATEMENT_FORMAT21c_TYPE_in_insn_format21c_type2643;
    public static final BitSet FOLLOW_I_STATEMENT_FORMAT21ih_in_insn_format21ih2672;
    public static final BitSet FOLLOW_I_STATEMENT_FORMAT21lh_in_insn_format21lh2701;
    public static final BitSet FOLLOW_I_STATEMENT_FORMAT21s_in_insn_format21s2730;
    public static final BitSet FOLLOW_I_STATEMENT_FORMAT21t_in_insn_format21t2759;
    public static final BitSet FOLLOW_I_STATEMENT_FORMAT22b_in_insn_format22b2788;
    public static final BitSet FOLLOW_I_STATEMENT_FORMAT22c_FIELD_in_insn_format22c_field2823;
    public static final BitSet FOLLOW_I_STATEMENT_FORMAT22c_TYPE_in_insn_format22c_type2866;
    public static final BitSet FOLLOW_I_STATEMENT_FORMAT22s_in_insn_format22s2901;
    public static final BitSet FOLLOW_I_STATEMENT_FORMAT22t_in_insn_format22t2936;
    public static final BitSet FOLLOW_I_STATEMENT_FORMAT22x_in_insn_format22x2971;
    public static final BitSet FOLLOW_I_STATEMENT_FORMAT23x_in_insn_format23x3004;
    public static final BitSet FOLLOW_I_STATEMENT_FORMAT30t_in_insn_format30t3041;
    public static final BitSet FOLLOW_I_STATEMENT_FORMAT31c_in_insn_format31c3068;
    public static final BitSet FOLLOW_I_STATEMENT_FORMAT31i_in_insn_format31i3097;
    public static final BitSet FOLLOW_I_STATEMENT_FORMAT31t_in_insn_format31t3126;
    public static final BitSet FOLLOW_I_STATEMENT_FORMAT32x_in_insn_format32x3155;

    /* JADX INFO: renamed from: FOLLOW_I_STATEMENT_FORMAT35c_CALL_SITE_in_insn_format35c_call_site3193 */
    public static final BitSet f4808x5b268606;
    public static final BitSet FOLLOW_I_STATEMENT_FORMAT35c_METHOD_in_insn_format35c_method3222;
    public static final BitSet FOLLOW_I_STATEMENT_FORMAT35c_TYPE_in_insn_format35c_type3251;

    /* JADX INFO: renamed from: FOLLOW_I_STATEMENT_FORMAT3rc_CALL_SITE_in_insn_format3rc_call_site3285 */
    public static final BitSet f4809x8d3d8370;
    public static final BitSet FOLLOW_I_STATEMENT_FORMAT3rc_METHOD_in_insn_format3rc_method3314;
    public static final BitSet FOLLOW_I_STATEMENT_FORMAT3rc_TYPE_in_insn_format3rc_type3343;

    /* JADX INFO: renamed from: FOLLOW_I_STATEMENT_FORMAT45cc_METHOD_in_insn_format45cc_method3372 */
    public static final BitSet f4810x586fb6b3;

    /* JADX INFO: renamed from: FOLLOW_I_STATEMENT_FORMAT4rcc_METHOD_in_insn_format4rcc_method3403 */
    public static final BitSet f4811xec6b29a2;
    public static final BitSet FOLLOW_I_STATEMENT_FORMAT51l_in_insn_format51l_type3434;

    /* JADX INFO: renamed from: FOLLOW_I_STATEMENT_PACKED_SWITCH_in_insn_packed_switch_directive3493 */
    public static final BitSet f4812x8c53fca9;

    /* JADX INFO: renamed from: FOLLOW_I_STATEMENT_SPARSE_SWITCH_in_insn_sparse_switch_directive3525 */
    public static final BitSet f4813x856d6443;
    public static final BitSet FOLLOW_I_SUBANNOTATION_in_subannotation4050;
    public static final BitSet FOLLOW_LONG_LITERAL_in_long_literal3803;
    public static final BitSet FOLLOW_NULL_LITERAL_in_local1733;
    public static final BitSet FOLLOW_PRIMITIVE_TYPE_in_array_descriptor3552;
    public static final BitSet FOLLOW_PRIMITIVE_TYPE_in_nonvoid_type_descriptor3598;
    public static final BitSet FOLLOW_REGISTER_in_end_local1770;
    public static final BitSet FOLLOW_REGISTER_in_insn_format11n2370;
    public static final BitSet FOLLOW_REGISTER_in_insn_format11x2399;
    public static final BitSet FOLLOW_REGISTER_in_insn_format12x2428;
    public static final BitSet FOLLOW_REGISTER_in_insn_format12x2432;
    public static final BitSet FOLLOW_REGISTER_in_insn_format21c_field2523;
    public static final BitSet FOLLOW_REGISTER_in_insn_format21c_method_handle2556;
    public static final BitSet FOLLOW_REGISTER_in_insn_format21c_method_type2589;
    public static final BitSet FOLLOW_REGISTER_in_insn_format21c_string2618;
    public static final BitSet FOLLOW_REGISTER_in_insn_format21c_type2647;
    public static final BitSet FOLLOW_REGISTER_in_insn_format21ih2676;
    public static final BitSet FOLLOW_REGISTER_in_insn_format21lh2705;
    public static final BitSet FOLLOW_REGISTER_in_insn_format21s2734;
    public static final BitSet FOLLOW_REGISTER_in_insn_format21t2763;
    public static final BitSet FOLLOW_REGISTER_in_insn_format22b2794;
    public static final BitSet FOLLOW_REGISTER_in_insn_format22b2798;
    public static final BitSet FOLLOW_REGISTER_in_insn_format22c_field2837;
    public static final BitSet FOLLOW_REGISTER_in_insn_format22c_field2841;
    public static final BitSet FOLLOW_REGISTER_in_insn_format22c_type2872;
    public static final BitSet FOLLOW_REGISTER_in_insn_format22c_type2876;
    public static final BitSet FOLLOW_REGISTER_in_insn_format22s2907;
    public static final BitSet FOLLOW_REGISTER_in_insn_format22s2911;
    public static final BitSet FOLLOW_REGISTER_in_insn_format22t2942;
    public static final BitSet FOLLOW_REGISTER_in_insn_format22t2946;
    public static final BitSet FOLLOW_REGISTER_in_insn_format22x2977;
    public static final BitSet FOLLOW_REGISTER_in_insn_format22x2981;
    public static final BitSet FOLLOW_REGISTER_in_insn_format23x3010;
    public static final BitSet FOLLOW_REGISTER_in_insn_format23x3014;
    public static final BitSet FOLLOW_REGISTER_in_insn_format23x3018;
    public static final BitSet FOLLOW_REGISTER_in_insn_format31c3072;
    public static final BitSet FOLLOW_REGISTER_in_insn_format31i3101;
    public static final BitSet FOLLOW_REGISTER_in_insn_format31t3130;
    public static final BitSet FOLLOW_REGISTER_in_insn_format32x3161;
    public static final BitSet FOLLOW_REGISTER_in_insn_format32x3165;
    public static final BitSet FOLLOW_REGISTER_in_insn_format51l_type3438;
    public static final BitSet FOLLOW_REGISTER_in_local1729;
    public static final BitSet FOLLOW_REGISTER_in_parameter1638;
    public static final BitSet FOLLOW_REGISTER_in_register_list1948;
    public static final BitSet FOLLOW_REGISTER_in_register_range1978;
    public static final BitSet FOLLOW_REGISTER_in_register_range1982;
    public static final BitSet FOLLOW_REGISTER_in_restart_local1790;
    public static final BitSet FOLLOW_SHORT_LITERAL_in_short_literal3818;
    public static final BitSet FOLLOW_SIMPLE_NAME_in_annotation_element4021;
    public static final BitSet FOLLOW_SIMPLE_NAME_in_field_reference1434;
    public static final BitSet FOLLOW_SIMPLE_NAME_in_label_def1514;
    public static final BitSet FOLLOW_SIMPLE_NAME_in_label_ref1914;
    public static final BitSet FOLLOW_SIMPLE_NAME_in_method_reference1412;
    public static final BitSet FOLLOW_STRING_LITERAL_in_string_literal3893;
    public static final BitSet FOLLOW_VERIFICATION_ERROR_TYPE_in_verification_error_type2042;
    public static final BitSet FOLLOW_VOID_TYPE_in_type_descriptor3663;
    public static final BitSet FOLLOW_annotation_element_in_subannotation4071;
    public static final BitSet FOLLOW_annotation_in_annotations3965;
    public static final BitSet FOLLOW_annotations_in_parameter1643;
    public static final BitSet FOLLOW_array_descriptor_in_nonvoid_type_descriptor3614;
    public static final BitSet FOLLOW_array_descriptor_in_reference_type_descriptor3643;
    public static final BitSet FOLLOW_array_elements_in_insn_array_data_directive3471;
    public static final BitSet FOLLOW_byte_literal_in_integral_literal3772;
    public static final BitSet FOLLOW_byte_literal_in_short_integral_literal3729;
    public static final BitSet FOLLOW_call_site_reference_in_insn_format35c_call_site3199;
    public static final BitSet FOLLOW_call_site_reference_in_insn_format3rc_call_site3291;
    public static final BitSet FOLLOW_catch_directive_in_catches1542;
    public static final BitSet FOLLOW_catchall_directive_in_catches1545;
    public static final BitSet FOLLOW_char_literal_in_short_integral_literal3721;
    public static final BitSet FOLLOW_debug_directive_in_ordered_method_items1898;
    public static final BitSet FOLLOW_end_local_in_debug_directive1672;
    public static final BitSet FOLLOW_epilogue_in_debug_directive1690;
    public static final BitSet FOLLOW_field_reference_in_enum_literal4158;
    public static final BitSet FOLLOW_field_reference_in_field_literal4112;
    public static final BitSet FOLLOW_field_reference_in_insn_format21c_field2525;
    public static final BitSet FOLLOW_field_reference_in_insn_format22c_field2843;
    public static final BitSet FOLLOW_field_reference_in_method_handle_reference1370;
    public static final BitSet FOLLOW_field_reference_in_verification_error_reference2015;
    public static final BitSet FOLLOW_fixed_32bit_literal_in_insn_format21ih2678;
    public static final BitSet FOLLOW_fixed_32bit_literal_in_insn_format31i3103;
    public static final BitSet FOLLOW_fixed_32bit_literal_in_insn_packed_switch_directive3498;
    public static final BitSet FOLLOW_fixed_64bit_literal_in_insn_format21lh2707;
    public static final BitSet FOLLOW_fixed_64bit_literal_in_insn_format51l_type3440;
    public static final BitSet FOLLOW_insn_array_data_directive_in_instruction2278;
    public static final BitSet FOLLOW_insn_format10t_in_instruction2056;
    public static final BitSet FOLLOW_insn_format10x_in_instruction2062;
    public static final BitSet FOLLOW_insn_format11n_in_instruction2068;
    public static final BitSet FOLLOW_insn_format11x_in_instruction2074;
    public static final BitSet FOLLOW_insn_format12x_in_instruction2080;
    public static final BitSet FOLLOW_insn_format20bc_in_instruction2086;
    public static final BitSet FOLLOW_insn_format20t_in_instruction2092;
    public static final BitSet FOLLOW_insn_format21c_field_in_instruction2098;
    public static final BitSet FOLLOW_insn_format21c_method_handle_in_instruction2104;
    public static final BitSet FOLLOW_insn_format21c_method_type_in_instruction2110;
    public static final BitSet FOLLOW_insn_format21c_string_in_instruction2116;
    public static final BitSet FOLLOW_insn_format21c_type_in_instruction2122;
    public static final BitSet FOLLOW_insn_format21ih_in_instruction2128;
    public static final BitSet FOLLOW_insn_format21lh_in_instruction2134;
    public static final BitSet FOLLOW_insn_format21s_in_instruction2140;
    public static final BitSet FOLLOW_insn_format21t_in_instruction2146;
    public static final BitSet FOLLOW_insn_format22b_in_instruction2152;
    public static final BitSet FOLLOW_insn_format22c_field_in_instruction2158;
    public static final BitSet FOLLOW_insn_format22c_type_in_instruction2164;
    public static final BitSet FOLLOW_insn_format22s_in_instruction2170;
    public static final BitSet FOLLOW_insn_format22t_in_instruction2176;
    public static final BitSet FOLLOW_insn_format22x_in_instruction2182;
    public static final BitSet FOLLOW_insn_format23x_in_instruction2188;
    public static final BitSet FOLLOW_insn_format30t_in_instruction2194;
    public static final BitSet FOLLOW_insn_format31c_in_instruction2200;
    public static final BitSet FOLLOW_insn_format31i_in_instruction2206;
    public static final BitSet FOLLOW_insn_format31t_in_instruction2212;
    public static final BitSet FOLLOW_insn_format32x_in_instruction2218;
    public static final BitSet FOLLOW_insn_format35c_call_site_in_instruction2224;
    public static final BitSet FOLLOW_insn_format35c_method_in_instruction2230;
    public static final BitSet FOLLOW_insn_format35c_type_in_instruction2236;
    public static final BitSet FOLLOW_insn_format3rc_call_site_in_instruction2242;
    public static final BitSet FOLLOW_insn_format3rc_method_in_instruction2248;
    public static final BitSet FOLLOW_insn_format3rc_type_in_instruction2254;
    public static final BitSet FOLLOW_insn_format45cc_method_in_instruction2260;
    public static final BitSet FOLLOW_insn_format4rcc_method_in_instruction2266;
    public static final BitSet FOLLOW_insn_format51l_type_in_instruction2272;
    public static final BitSet FOLLOW_insn_packed_switch_directive_in_instruction2284;
    public static final BitSet FOLLOW_insn_sparse_switch_directive_in_instruction2290;
    public static final BitSet FOLLOW_instruction_in_ordered_method_items1894;
    public static final BitSet FOLLOW_integer_literal_in_integral_literal3756;
    public static final BitSet FOLLOW_integer_literal_in_short_integral_literal3701;
    public static final BitSet FOLLOW_integral_literal_in_line1709;
    public static final BitSet FOLLOW_label_def_in_ordered_method_items1890;
    public static final BitSet FOLLOW_label_ref_in_catch_directive1564;
    public static final BitSet FOLLOW_label_ref_in_catch_directive1568;
    public static final BitSet FOLLOW_label_ref_in_catch_directive1572;
    public static final BitSet FOLLOW_label_ref_in_catchall_directive1592;
    public static final BitSet FOLLOW_label_ref_in_catchall_directive1596;
    public static final BitSet FOLLOW_label_ref_in_catchall_directive1600;
    public static final BitSet FOLLOW_label_ref_in_insn_format10t2318;
    public static final BitSet FOLLOW_label_ref_in_insn_format20t2488;
    public static final BitSet FOLLOW_label_ref_in_insn_format21t2765;
    public static final BitSet FOLLOW_label_ref_in_insn_format22t2948;
    public static final BitSet FOLLOW_label_ref_in_insn_format30t3045;
    public static final BitSet FOLLOW_label_ref_in_insn_format31t3132;
    public static final BitSet FOLLOW_line_in_debug_directive1660;
    public static final BitSet FOLLOW_literal_in_annotation_element4023;
    public static final BitSet FOLLOW_literal_in_array_literal3937;
    public static final BitSet FOLLOW_literal_in_call_site_extra_arguments1871;
    public static final BitSet FOLLOW_local_in_debug_directive1666;
    public static final BitSet FOLLOW_long_literal_in_integral_literal3744;
    public static final BitSet FOLLOW_long_literal_in_short_integral_literal3689;

    /* JADX INFO: renamed from: FOLLOW_method_handle_reference_in_insn_format21c_method_handle2558 */
    public static final BitSet f4814xd17b2dfa;
    public static final BitSet FOLLOW_method_handle_reference_in_method_handle_literal1393;
    public static final BitSet FOLLOW_method_handle_type_in_method_handle_reference1367;
    public static final BitSet FOLLOW_method_prototype_in_insn_format21c_method_type2591;
    public static final BitSet FOLLOW_method_prototype_in_insn_format45cc_method3380;
    public static final BitSet FOLLOW_method_prototype_in_insn_format4rcc_method3411;
    public static final BitSet FOLLOW_method_prototype_in_method_reference1414;
    public static final BitSet FOLLOW_method_reference_in_insn_format35c_method3228;
    public static final BitSet FOLLOW_method_reference_in_insn_format3rc_method3320;
    public static final BitSet FOLLOW_method_reference_in_insn_format45cc_method3378;
    public static final BitSet FOLLOW_method_reference_in_insn_format4rcc_method3409;
    public static final BitSet FOLLOW_method_reference_in_method_handle_reference1374;
    public static final BitSet FOLLOW_method_reference_in_method_literal4135;
    public static final BitSet FOLLOW_method_reference_in_verification_error_reference2025;
    public static final BitSet FOLLOW_nonvoid_type_descriptor_in_catch_directive1560;
    public static final BitSet FOLLOW_nonvoid_type_descriptor_in_field_reference1436;
    public static final BitSet FOLLOW_nonvoid_type_descriptor_in_insn_format21c_type2649;
    public static final BitSet FOLLOW_nonvoid_type_descriptor_in_insn_format22c_type2878;
    public static final BitSet FOLLOW_nonvoid_type_descriptor_in_insn_format35c_type3257;
    public static final BitSet FOLLOW_nonvoid_type_descriptor_in_insn_format3rc_type3349;
    public static final BitSet FOLLOW_nonvoid_type_descriptor_in_local1742;
    public static final BitSet FOLLOW_nonvoid_type_descriptor_in_type_descriptor3671;

    /* JADX INFO: renamed from: FOLLOW_packed_switch_elements_in_insn_packed_switch_directive3501 */
    public static final BitSet f4815xf8430993;
    public static final BitSet FOLLOW_parameter_in_parameters1620;
    public static final BitSet FOLLOW_prologue_in_debug_directive1684;
    public static final BitSet FOLLOW_reference_type_descriptor_in_field_reference1431;
    public static final BitSet FOLLOW_reference_type_descriptor_in_method_reference1409;
    public static final BitSet FOLLOW_register_list_in_insn_format35c_call_site3197;
    public static final BitSet FOLLOW_register_list_in_insn_format35c_method3226;
    public static final BitSet FOLLOW_register_list_in_insn_format35c_type3255;
    public static final BitSet FOLLOW_register_list_in_insn_format45cc_method3376;
    public static final BitSet FOLLOW_register_range_in_insn_format3rc_call_site3289;
    public static final BitSet FOLLOW_register_range_in_insn_format3rc_method3318;
    public static final BitSet FOLLOW_register_range_in_insn_format3rc_type3347;
    public static final BitSet FOLLOW_register_range_in_insn_format4rcc_method3407;
    public static final BitSet FOLLOW_restart_local_in_debug_directive1678;
    public static final BitSet FOLLOW_short_integral_literal_in_insn_array_data_directive3468;
    public static final BitSet FOLLOW_short_integral_literal_in_insn_format11n2372;
    public static final BitSet FOLLOW_short_integral_literal_in_insn_format21s2736;
    public static final BitSet FOLLOW_short_integral_literal_in_insn_format22b2800;
    public static final BitSet FOLLOW_short_integral_literal_in_insn_format22s2913;
    public static final BitSet FOLLOW_short_integral_literal_in_registers_directive1492;
    public static final BitSet FOLLOW_short_literal_in_integral_literal3764;
    public static final BitSet FOLLOW_short_literal_in_short_integral_literal3713;
    public static final BitSet FOLLOW_source_in_debug_directive1696;

    /* JADX INFO: renamed from: FOLLOW_sparse_switch_elements_in_insn_sparse_switch_directive3527 */
    public static final BitSet f4816x24e99ed7;
    public static final BitSet FOLLOW_string_literal_in_insn_format21c_string2620;
    public static final BitSet FOLLOW_string_literal_in_insn_format31c3074;
    public static final BitSet FOLLOW_string_literal_in_local1739;
    public static final BitSet FOLLOW_string_literal_in_local1747;
    public static final BitSet FOLLOW_string_literal_in_parameter1640;
    public static final BitSet FOLLOW_string_literal_in_source1842;
    public static final BitSet FOLLOW_subannotation_in_annotation3998;
    public static final BitSet FOLLOW_verification_error_reference_in_insn_format20bc2461;
    public static final BitSet FOLLOW_verification_error_type_in_insn_format20bc2459;
    public int apiLevel;
    public String classType;
    public DexBuilder dexBuilder;
    public String errMessages;
    public Stack<method_scope> method_stack;
    public Opcodes opcodes;
    public boolean verboseErrors;
    public static final String[] tokenNames = {"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ACCESS_SPEC", "ANNOTATION_DIRECTIVE", "ANNOTATION_VISIBILITY", "ARRAY_DATA_DIRECTIVE", "ARRAY_TYPE_PREFIX", "ARROW", "AT", "BOOL_LITERAL", "BYTE_LITERAL", "CATCHALL_DIRECTIVE", "CATCH_DIRECTIVE", "CHAR_LITERAL", "CLASS_DESCRIPTOR", "CLASS_DIRECTIVE", "CLOSE_BRACE", "CLOSE_PAREN", "COLON", "COMMA", "DOTDOT", "DOUBLE_LITERAL", "DOUBLE_LITERAL_OR_ID", "END_ANNOTATION_DIRECTIVE", "END_ARRAY_DATA_DIRECTIVE", "END_FIELD_DIRECTIVE", "END_LOCAL_DIRECTIVE", "END_METHOD_DIRECTIVE", "END_PACKED_SWITCH_DIRECTIVE", "END_PARAMETER_DIRECTIVE", "END_SPARSE_SWITCH_DIRECTIVE", "END_SUBANNOTATION_DIRECTIVE", "ENUM_DIRECTIVE", "EPILOGUE_DIRECTIVE", "EQUAL", "FIELD_DIRECTIVE", "FIELD_OFFSET", "FLOAT_LITERAL", "FLOAT_LITERAL_OR_ID", "HIDDENAPI_RESTRICTION", "IMPLEMENTS_DIRECTIVE", "INLINE_INDEX", "INSTRUCTION_FORMAT10t", "INSTRUCTION_FORMAT10x", "INSTRUCTION_FORMAT10x_ODEX", "INSTRUCTION_FORMAT11n", "INSTRUCTION_FORMAT11x", "INSTRUCTION_FORMAT12x", "INSTRUCTION_FORMAT12x_OR_ID", "INSTRUCTION_FORMAT20bc", "INSTRUCTION_FORMAT20t", "INSTRUCTION_FORMAT21c_FIELD", "INSTRUCTION_FORMAT21c_FIELD_ODEX", "INSTRUCTION_FORMAT21c_METHOD_HANDLE", "INSTRUCTION_FORMAT21c_METHOD_TYPE", "INSTRUCTION_FORMAT21c_STRING", "INSTRUCTION_FORMAT21c_TYPE", "INSTRUCTION_FORMAT21ih", "INSTRUCTION_FORMAT21lh", "INSTRUCTION_FORMAT21s", "INSTRUCTION_FORMAT21t", "INSTRUCTION_FORMAT22b", "INSTRUCTION_FORMAT22c_FIELD", "INSTRUCTION_FORMAT22c_FIELD_ODEX", "INSTRUCTION_FORMAT22c_TYPE", "INSTRUCTION_FORMAT22cs_FIELD", "INSTRUCTION_FORMAT22s", "INSTRUCTION_FORMAT22s_OR_ID", "INSTRUCTION_FORMAT22t", "INSTRUCTION_FORMAT22x", "INSTRUCTION_FORMAT23x", "INSTRUCTION_FORMAT30t", "INSTRUCTION_FORMAT31c", "INSTRUCTION_FORMAT31i", "INSTRUCTION_FORMAT31i_OR_ID", "INSTRUCTION_FORMAT31t", "INSTRUCTION_FORMAT32x", "INSTRUCTION_FORMAT35c_CALL_SITE", "INSTRUCTION_FORMAT35c_METHOD", "INSTRUCTION_FORMAT35c_METHOD_ODEX", "INSTRUCTION_FORMAT35c_METHOD_OR_METHOD_HANDLE_TYPE", "INSTRUCTION_FORMAT35c_TYPE", "INSTRUCTION_FORMAT35mi_METHOD", "INSTRUCTION_FORMAT35ms_METHOD", "INSTRUCTION_FORMAT3rc_CALL_SITE", "INSTRUCTION_FORMAT3rc_METHOD", "INSTRUCTION_FORMAT3rc_METHOD_ODEX", "INSTRUCTION_FORMAT3rc_TYPE", "INSTRUCTION_FORMAT3rmi_METHOD", "INSTRUCTION_FORMAT3rms_METHOD", "INSTRUCTION_FORMAT45cc_METHOD", "INSTRUCTION_FORMAT4rcc_METHOD", "INSTRUCTION_FORMAT51l", "INTEGER_LITERAL", "INVALID_TOKEN", "I_ACCESS_LIST", "I_ACCESS_OR_RESTRICTION_LIST", "I_ANNOTATION", "I_ANNOTATIONS", "I_ANNOTATION_ELEMENT", "I_ARRAY_ELEMENTS", "I_ARRAY_ELEMENT_SIZE", "I_CALL_SITE_EXTRA_ARGUMENTS", "I_CALL_SITE_REFERENCE", "I_CATCH", "I_CATCHALL", "I_CATCHES", "I_CLASS_DEF", "I_ENCODED_ARRAY", "I_ENCODED_ENUM", "I_ENCODED_FIELD", "I_ENCODED_METHOD", "I_ENCODED_METHOD_HANDLE", "I_END_LOCAL", "I_EPILOGUE", "I_FIELD", "I_FIELDS", "I_FIELD_INITIAL_VALUE", "I_FIELD_TYPE", "I_IMPLEMENTS", "I_LABEL", "I_LINE", "I_LOCAL", "I_LOCALS", "I_METHOD", "I_METHODS", "I_METHOD_PROTOTYPE", "I_METHOD_RETURN_TYPE", "I_ORDERED_METHOD_ITEMS", "I_PACKED_SWITCH_ELEMENTS", "I_PACKED_SWITCH_START_KEY", "I_PARAMETER", "I_PARAMETERS", "I_PARAMETER_NOT_SPECIFIED", "I_PROLOGUE", "I_REGISTERS", "I_REGISTER_LIST", "I_REGISTER_RANGE", "I_RESTART_LOCAL", "I_SOURCE", "I_SPARSE_SWITCH_ELEMENTS", "I_STATEMENT_ARRAY_DATA", "I_STATEMENT_FORMAT10t", "I_STATEMENT_FORMAT10x", "I_STATEMENT_FORMAT11n", "I_STATEMENT_FORMAT11x", "I_STATEMENT_FORMAT12x", "I_STATEMENT_FORMAT20bc", "I_STATEMENT_FORMAT20t", "I_STATEMENT_FORMAT21c_FIELD", "I_STATEMENT_FORMAT21c_METHOD_HANDLE", "I_STATEMENT_FORMAT21c_METHOD_TYPE", "I_STATEMENT_FORMAT21c_STRING", "I_STATEMENT_FORMAT21c_TYPE", "I_STATEMENT_FORMAT21ih", "I_STATEMENT_FORMAT21lh", "I_STATEMENT_FORMAT21s", "I_STATEMENT_FORMAT21t", "I_STATEMENT_FORMAT22b", "I_STATEMENT_FORMAT22c_FIELD", "I_STATEMENT_FORMAT22c_TYPE", "I_STATEMENT_FORMAT22s", "I_STATEMENT_FORMAT22t", "I_STATEMENT_FORMAT22x", "I_STATEMENT_FORMAT23x", "I_STATEMENT_FORMAT30t", "I_STATEMENT_FORMAT31c", "I_STATEMENT_FORMAT31i", "I_STATEMENT_FORMAT31t", "I_STATEMENT_FORMAT32x", "I_STATEMENT_FORMAT35c_CALL_SITE", "I_STATEMENT_FORMAT35c_METHOD", "I_STATEMENT_FORMAT35c_TYPE", "I_STATEMENT_FORMAT3rc_CALL_SITE", "I_STATEMENT_FORMAT3rc_METHOD", "I_STATEMENT_FORMAT3rc_TYPE", "I_STATEMENT_FORMAT45cc_METHOD", "I_STATEMENT_FORMAT4rcc_METHOD", "I_STATEMENT_FORMAT51l", "I_STATEMENT_PACKED_SWITCH", "I_STATEMENT_SPARSE_SWITCH", "I_SUBANNOTATION", "I_SUPER", "LINE_COMMENT", "LINE_DIRECTIVE", "LOCALS_DIRECTIVE", "LOCAL_DIRECTIVE", "LONG_LITERAL", "MEMBER_NAME", "METHOD_DIRECTIVE", "METHOD_HANDLE_TYPE_FIELD", "METHOD_HANDLE_TYPE_METHOD", "NEGATIVE_INTEGER_LITERAL", "NULL_LITERAL", "OPEN_BRACE", "OPEN_PAREN", "PACKED_SWITCH_DIRECTIVE", "PARAMETER_DIRECTIVE", "PARAM_LIST_OR_ID_PRIMITIVE_TYPE", "POSITIVE_INTEGER_LITERAL", "PRIMITIVE_TYPE", "PROLOGUE_DIRECTIVE", "REGISTER", "REGISTERS_DIRECTIVE", "RESTART_LOCAL_DIRECTIVE", "SHORT_LITERAL", "SIMPLE_NAME", "SOURCE_DIRECTIVE", "SPARSE_SWITCH_DIRECTIVE", "STRING_LITERAL", "SUBANNOTATION_DIRECTIVE", "SUPER_DIRECTIVE", "VERIFICATION_ERROR_TYPE", "VOID_TYPE", "VTABLE_INDEX", "WHITE_SPACE"};
    public static final BitSet FOLLOW_I_CLASS_DEF_in_smali_file52 = new BitSet(new long[]{4});
    public static final BitSet FOLLOW_header_in_smali_file54 = new BitSet(new long[]{0, Long.MIN_VALUE});
    public static final BitSet FOLLOW_methods_in_smali_file56 = new BitSet(new long[]{0, 18014398509481984L});
    public static final BitSet FOLLOW_fields_in_smali_file58 = new BitSet(new long[]{0, 68719476736L});
    public static final BitSet FOLLOW_annotations_in_smali_file60 = new BitSet(new long[]{8});
    public static final BitSet FOLLOW_class_spec_in_header85 = new BitSet(new long[]{0, 144115188075855872L, 72057594037936128L});
    public static final BitSet FOLLOW_super_spec_in_header87 = new BitSet(new long[]{0, 144115188075855872L, PlaybackStateCompat.ACTION_PLAY_FROM_URI});
    public static final BitSet FOLLOW_implements_list_in_header90 = new BitSet(new long[]{0, 0, PlaybackStateCompat.ACTION_PLAY_FROM_URI});
    public static final BitSet FOLLOW_source_spec_in_header92 = new BitSet(new long[]{2});
    public static final BitSet FOLLOW_CLASS_DESCRIPTOR_in_class_spec110 = new BitSet(new long[]{0, 8589934592L});
    public static final BitSet FOLLOW_access_list_in_class_spec112 = new BitSet(new long[]{2});
    public static final BitSet FOLLOW_I_SUPER_in_super_spec130 = new BitSet(new long[]{4});
    public static final BitSet FOLLOW_CLASS_DESCRIPTOR_in_super_spec132 = new BitSet(new long[]{8});
    public static final BitSet FOLLOW_I_IMPLEMENTS_in_implements_spec152 = new BitSet(new long[]{4});
    public static final BitSet FOLLOW_CLASS_DESCRIPTOR_in_implements_spec154 = new BitSet(new long[]{8});
    public static final BitSet FOLLOW_implements_spec_in_implements_list184 = new BitSet(new long[]{2, 144115188075855872L});
    public static final BitSet FOLLOW_I_SOURCE_in_source_spec213 = new BitSet(new long[]{4});
    public static final BitSet FOLLOW_string_literal_in_source_spec215 = new BitSet(new long[]{8});
    public static final BitSet FOLLOW_I_ACCESS_LIST_in_access_list247 = new BitSet(new long[]{4});
    public static final BitSet FOLLOW_ACCESS_SPEC_in_access_list265 = new BitSet(new long[]{24});

    /* JADX INFO: renamed from: FOLLOW_I_ACCESS_OR_RESTRICTION_LIST_in_access_or_restriction_list308 */
    public static final BitSet f4803xc8f81cb8 = new BitSet(new long[]{4});
    public static final BitSet FOLLOW_ACCESS_SPEC_in_access_or_restriction_list326 = new BitSet(new long[]{2199023255576L});
    public static final BitSet FOLLOW_HIDDENAPI_RESTRICTION_in_access_or_restriction_list356 = new BitSet(new long[]{2199023255576L});
    public static final BitSet FOLLOW_I_FIELDS_in_fields405 = new BitSet(new long[]{4});
    public static final BitSet FOLLOW_field_in_fields414 = new BitSet(new long[]{8, 9007199254740992L});
    public static final BitSet FOLLOW_I_METHODS_in_methods446 = new BitSet(new long[]{4});
    public static final BitSet FOLLOW_method_in_methods455 = new BitSet(new long[]{8, 4611686018427387904L});
    public static final BitSet FOLLOW_I_FIELD_in_field480 = new BitSet(new long[]{4});
    public static final BitSet FOLLOW_SIMPLE_NAME_in_field482 = new BitSet(new long[]{0, 17179869184L});
    public static final BitSet FOLLOW_access_or_restriction_list_in_field484 = new BitSet(new long[]{0, 72057594037927936L});
    public static final BitSet FOLLOW_I_FIELD_TYPE_in_field487 = new BitSet(new long[]{4});
    public static final BitSet FOLLOW_nonvoid_type_descriptor_in_field489 = new BitSet(new long[]{8});
    public static final BitSet FOLLOW_field_initial_value_in_field492 = new BitSet(new long[]{8, 68719476736L});
    public static final BitSet FOLLOW_annotations_in_field494 = new BitSet(new long[]{8});
    public static final BitSet FOLLOW_I_FIELD_INITIAL_VALUE_in_field_initial_value515 = new BitSet(new long[]{4});
    public static final BitSet FOLLOW_literal_in_field_initial_value517 = new BitSet(new long[]{8});
    public static final BitSet FOLLOW_integer_literal_in_literal539 = new BitSet(new long[]{2});
    public static final BitSet FOLLOW_long_literal_in_literal547 = new BitSet(new long[]{2});
    public static final BitSet FOLLOW_short_literal_in_literal555 = new BitSet(new long[]{2});
    public static final BitSet FOLLOW_byte_literal_in_literal563 = new BitSet(new long[]{2});
    public static final BitSet FOLLOW_float_literal_in_literal571 = new BitSet(new long[]{2});
    public static final BitSet FOLLOW_double_literal_in_literal579 = new BitSet(new long[]{2});
    public static final BitSet FOLLOW_char_literal_in_literal587 = new BitSet(new long[]{2});
    public static final BitSet FOLLOW_string_literal_in_literal595 = new BitSet(new long[]{2});
    public static final BitSet FOLLOW_bool_literal_in_literal603 = new BitSet(new long[]{2});
    public static final BitSet FOLLOW_NULL_LITERAL_in_literal611 = new BitSet(new long[]{2});
    public static final BitSet FOLLOW_type_descriptor_in_literal619 = new BitSet(new long[]{2});
    public static final BitSet FOLLOW_array_literal_in_literal627 = new BitSet(new long[]{2});
    public static final BitSet FOLLOW_subannotation_in_literal635 = new BitSet(new long[]{2});
    public static final BitSet FOLLOW_field_literal_in_literal643 = new BitSet(new long[]{2});
    public static final BitSet FOLLOW_method_literal_in_literal651 = new BitSet(new long[]{2});
    public static final BitSet FOLLOW_enum_literal_in_literal659 = new BitSet(new long[]{2});
    public static final BitSet FOLLOW_method_handle_literal_in_literal667 = new BitSet(new long[]{2});
    public static final BitSet FOLLOW_method_prototype_in_literal675 = new BitSet(new long[]{2});
    public static final BitSet FOLLOW_integer_literal_in_fixed_64bit_literal_number691 = new BitSet(new long[]{2});
    public static final BitSet FOLLOW_long_literal_in_fixed_64bit_literal_number699 = new BitSet(new long[]{2});
    public static final BitSet FOLLOW_short_literal_in_fixed_64bit_literal_number707 = new BitSet(new long[]{2});
    public static final BitSet FOLLOW_byte_literal_in_fixed_64bit_literal_number715 = new BitSet(new long[]{2});
    public static final BitSet FOLLOW_float_literal_in_fixed_64bit_literal_number723 = new BitSet(new long[]{2});
    public static final BitSet FOLLOW_double_literal_in_fixed_64bit_literal_number731 = new BitSet(new long[]{2});
    public static final BitSet FOLLOW_char_literal_in_fixed_64bit_literal_number739 = new BitSet(new long[]{2});
    public static final BitSet FOLLOW_bool_literal_in_fixed_64bit_literal_number747 = new BitSet(new long[]{2});
    public static final BitSet FOLLOW_integer_literal_in_fixed_64bit_literal762 = new BitSet(new long[]{2});
    public static final BitSet FOLLOW_long_literal_in_fixed_64bit_literal770 = new BitSet(new long[]{2});
    public static final BitSet FOLLOW_short_literal_in_fixed_64bit_literal778 = new BitSet(new long[]{2});
    public static final BitSet FOLLOW_byte_literal_in_fixed_64bit_literal786 = new BitSet(new long[]{2});
    public static final BitSet FOLLOW_float_literal_in_fixed_64bit_literal794 = new BitSet(new long[]{2});
    public static final BitSet FOLLOW_double_literal_in_fixed_64bit_literal802 = new BitSet(new long[]{2});
    public static final BitSet FOLLOW_char_literal_in_fixed_64bit_literal810 = new BitSet(new long[]{2});
    public static final BitSet FOLLOW_bool_literal_in_fixed_64bit_literal818 = new BitSet(new long[]{2});
    public static final BitSet FOLLOW_integer_literal_in_fixed_32bit_literal835 = new BitSet(new long[]{2});
    public static final BitSet FOLLOW_long_literal_in_fixed_32bit_literal843 = new BitSet(new long[]{2});
    public static final BitSet FOLLOW_short_literal_in_fixed_32bit_literal851 = new BitSet(new long[]{2});
    public static final BitSet FOLLOW_byte_literal_in_fixed_32bit_literal859 = new BitSet(new long[]{2});
    public static final BitSet FOLLOW_float_literal_in_fixed_32bit_literal867 = new BitSet(new long[]{2});
    public static final BitSet FOLLOW_char_literal_in_fixed_32bit_literal875 = new BitSet(new long[]{2});
    public static final BitSet FOLLOW_bool_literal_in_fixed_32bit_literal883 = new BitSet(new long[]{2});
    public static final BitSet FOLLOW_I_ARRAY_ELEMENTS_in_array_elements905 = new BitSet(new long[]{4});
    public static final BitSet FOLLOW_fixed_64bit_literal_number_in_array_elements914 = new BitSet(new long[]{549764241416L, 2147483648L, 2305843009213693952L, PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID});
    public static final BitSet FOLLOW_I_PACKED_SWITCH_ELEMENTS_in_packed_switch_elements950 = new BitSet(new long[]{4});
    public static final BitSet FOLLOW_label_ref_in_packed_switch_elements959 = new BitSet(new long[]{8, 0, 0, PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH});
    public static final BitSet FOLLOW_I_SPARSE_SWITCH_ELEMENTS_in_sparse_switch_elements994 = new BitSet(new long[]{4});
    public static final BitSet FOLLOW_fixed_32bit_literal_in_sparse_switch_elements1004 = new BitSet(new long[]{0, 0, 0, PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH});
    public static final BitSet FOLLOW_label_ref_in_sparse_switch_elements1006 = new BitSet(new long[]{549755852808L, 2147483648L, 2305843009213693952L, PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID});
    public static final BitSet FOLLOW_I_METHOD_in_method1058 = new BitSet(new long[]{4});
    public static final BitSet FOLLOW_method_name_and_prototype_in_method1066 = new BitSet(new long[]{0, 17179869184L});
    public static final BitSet FOLLOW_access_or_restriction_list_in_method1074 = new BitSet(new long[]{0, 2305843009213693952L, 516});
    public static final BitSet FOLLOW_registers_directive_in_method1101 = new BitSet(new long[]{0, 0, 4});
    public static final BitSet FOLLOW_ordered_method_items_in_method1158 = new BitSet(new long[]{0, 17592186044416L});
    public static final BitSet FOLLOW_catches_in_method1166 = new BitSet(new long[]{0, 0, 64});
    public static final BitSet FOLLOW_parameters_in_method1174 = new BitSet(new long[]{0, 68719476736L});
    public static final BitSet FOLLOW_annotations_in_method1183 = new BitSet(new long[]{8});
    public static final BitSet FOLLOW_I_METHOD_PROTOTYPE_in_method_prototype1207 = new BitSet(new long[]{4});
    public static final BitSet FOLLOW_I_METHOD_RETURN_TYPE_in_method_prototype1210 = new BitSet(new long[]{4});
    public static final BitSet FOLLOW_type_descriptor_in_method_prototype1212 = new BitSet(new long[]{8});
    public static final BitSet FOLLOW_method_type_list_in_method_prototype1215 = new BitSet(new long[]{8});
    public static final BitSet FOLLOW_SIMPLE_NAME_in_method_name_and_prototype1233 = new BitSet(new long[]{0, 0, 1});
    public static final BitSet FOLLOW_method_prototype_in_method_name_and_prototype1235 = new BitSet(new long[]{2});
    public static final BitSet FOLLOW_nonvoid_type_descriptor_in_method_type_list1269 = new BitSet(new long[]{65794, 0, 0, PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID});
    public static final BitSet FOLLOW_I_CALL_SITE_REFERENCE_in_call_site_reference1300 = new BitSet(new long[]{4});
    public static final BitSet FOLLOW_SIMPLE_NAME_in_call_site_reference1304 = new BitSet(new long[]{0, 0, 0, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED});
    public static final BitSet FOLLOW_string_literal_in_call_site_reference1308 = new BitSet(new long[]{0, 0, 1});
    public static final BitSet FOLLOW_method_prototype_in_call_site_reference1310 = new BitSet(new long[]{0, 1099511627776L});
    public static final BitSet FOLLOW_call_site_extra_arguments_in_call_site_reference1320 = new BitSet(new long[]{65792, 0, 0, PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH});
    public static final BitSet FOLLOW_method_reference_in_call_site_reference1322 = new BitSet(new long[]{8});

    public static class access_or_restriction_list_return extends TreeRuleReturnScope {
        public Set<HiddenApiRestriction> hiddenApiRestrictions;
        public int value;
    }

    public static class class_spec_return extends TreeRuleReturnScope {
        public int accessFlags;
        public String type;
    }

    public static class field_reference_return extends TreeRuleReturnScope {
        public ImmutableFieldReference fieldReference;
    }

    public static class header_return extends TreeRuleReturnScope {
        public int accessFlags;
        public String classType;
        public List<String> implementsList;
        public String sourceSpec;
        public String superType;
    }

    public static class instruction_return extends TreeRuleReturnScope {
    }

    public static class method_handle_type_return extends TreeRuleReturnScope {
        public int methodHandleType;
    }

    public static class method_name_and_prototype_return extends TreeRuleReturnScope {
        public String name;
        public List<SmaliMethodParameter> parameters;
        public String returnType;
    }

    public static class method_scope {
        public boolean isStatic;
        public MethodImplementationBuilder methodBuilder;
        public int methodParameterRegisters;
        public int totalMethodRegisters;
    }

    public static class nonvoid_type_descriptor_return extends TreeRuleReturnScope {
        public String type;
    }

    public static class reference_type_descriptor_return extends TreeRuleReturnScope {
        public String type;
    }

    public static class register_list_return extends TreeRuleReturnScope {
        public byte registerCount;
        public byte[] registers;
    }

    public static class register_range_return extends TreeRuleReturnScope {
        public int endRegister;
        public int startRegister;
    }

    public static class registers_directive_return extends TreeRuleReturnScope {
        public boolean isLocalsDirective;
        public int registers;
    }

    public static class subannotation_return extends TreeRuleReturnScope {
        public String annotationType;
        public List<AnnotationElement> elements;
    }

    static {
        new BitSet(new long[]{2});
        FOLLOW_method_handle_type_in_method_handle_reference1367 = new BitSet(new long[]{65792, 0, 0, PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH});
        FOLLOW_field_reference_in_method_handle_reference1370 = new BitSet(new long[]{2});
        FOLLOW_method_reference_in_method_handle_reference1374 = new BitSet(new long[]{2});
        FOLLOW_I_ENCODED_METHOD_HANDLE_in_method_handle_literal1391 = new BitSet(new long[]{4});
        FOLLOW_method_handle_reference_in_method_handle_literal1393 = new BitSet(new long[]{8});
        FOLLOW_reference_type_descriptor_in_method_reference1409 = new BitSet(new long[]{0, 0, 0, PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH});
        FOLLOW_SIMPLE_NAME_in_method_reference1412 = new BitSet(new long[]{0, 0, 1});
        FOLLOW_method_prototype_in_method_reference1414 = new BitSet(new long[]{2});
        FOLLOW_reference_type_descriptor_in_field_reference1431 = new BitSet(new long[]{0, 0, 0, PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH});
        FOLLOW_SIMPLE_NAME_in_field_reference1434 = new BitSet(new long[]{65792, 0, 0, PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID});
        FOLLOW_nonvoid_type_descriptor_in_field_reference1436 = new BitSet(new long[]{2});
        FOLLOW_I_REGISTERS_in_registers_directive1462 = new BitSet(new long[]{4});
        FOLLOW_I_LOCALS_in_registers_directive1474 = new BitSet(new long[]{4});
        FOLLOW_short_integral_literal_in_registers_directive1492 = new BitSet(new long[]{8});
        FOLLOW_I_LABEL_in_label_def1512 = new BitSet(new long[]{4});
        FOLLOW_SIMPLE_NAME_in_label_def1514 = new BitSet(new long[]{8});
        FOLLOW_I_CATCHES_in_catches1540 = new BitSet(new long[]{4});
        FOLLOW_catch_directive_in_catches1542 = new BitSet(new long[]{8, 13194139533312L});
        FOLLOW_catchall_directive_in_catches1545 = new BitSet(new long[]{8, 8796093022208L});
        FOLLOW_I_CATCH_in_catch_directive1558 = new BitSet(new long[]{4});
        FOLLOW_nonvoid_type_descriptor_in_catch_directive1560 = new BitSet(new long[]{0, 0, 0, PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH});
        FOLLOW_label_ref_in_catch_directive1564 = new BitSet(new long[]{0, 0, 0, PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH});
        FOLLOW_label_ref_in_catch_directive1568 = new BitSet(new long[]{0, 0, 0, PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH});
        FOLLOW_label_ref_in_catch_directive1572 = new BitSet(new long[]{8});
        FOLLOW_I_CATCHALL_in_catchall_directive1588 = new BitSet(new long[]{4});
        FOLLOW_label_ref_in_catchall_directive1592 = new BitSet(new long[]{0, 0, 0, PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH});
        FOLLOW_label_ref_in_catchall_directive1596 = new BitSet(new long[]{0, 0, 0, PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH});
        FOLLOW_label_ref_in_catchall_directive1600 = new BitSet(new long[]{8});
        FOLLOW_I_PARAMETERS_in_parameters1617 = new BitSet(new long[]{4});
        FOLLOW_parameter_in_parameters1620 = new BitSet(new long[]{8, 0, 32});
        FOLLOW_I_PARAMETER_in_parameter1636 = new BitSet(new long[]{4});
        FOLLOW_REGISTER_in_parameter1638 = new BitSet(new long[]{0, 68719476736L, 0, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED});
        FOLLOW_string_literal_in_parameter1640 = new BitSet(new long[]{0, 68719476736L});
        FOLLOW_annotations_in_parameter1643 = new BitSet(new long[]{8});
        FOLLOW_line_in_debug_directive1660 = new BitSet(new long[]{2});
        FOLLOW_local_in_debug_directive1666 = new BitSet(new long[]{2});
        FOLLOW_end_local_in_debug_directive1672 = new BitSet(new long[]{2});
        FOLLOW_restart_local_in_debug_directive1678 = new BitSet(new long[]{2});
        FOLLOW_prologue_in_debug_directive1684 = new BitSet(new long[]{2});
        FOLLOW_epilogue_in_debug_directive1690 = new BitSet(new long[]{2});
        FOLLOW_source_in_debug_directive1696 = new BitSet(new long[]{2});
        FOLLOW_I_LINE_in_line1707 = new BitSet(new long[]{4});
        FOLLOW_integral_literal_in_line1709 = new BitSet(new long[]{8});
        FOLLOW_I_LOCAL_in_local1727 = new BitSet(new long[]{4});
        FOLLOW_REGISTER_in_local1729 = new BitSet(new long[]{8, 0, 0, 524296});
        FOLLOW_NULL_LITERAL_in_local1733 = new BitSet(new long[]{65800, 0, 0, 525312});
        FOLLOW_string_literal_in_local1739 = new BitSet(new long[]{65800, 0, 0, 525312});
        FOLLOW_nonvoid_type_descriptor_in_local1742 = new BitSet(new long[]{8, 0, 0, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED});
        FOLLOW_string_literal_in_local1747 = new BitSet(new long[]{8});
        FOLLOW_I_END_LOCAL_in_end_local1768 = new BitSet(new long[]{4});
        FOLLOW_REGISTER_in_end_local1770 = new BitSet(new long[]{8});
        FOLLOW_I_RESTART_LOCAL_in_restart_local1788 = new BitSet(new long[]{4});
        FOLLOW_REGISTER_in_restart_local1790 = new BitSet(new long[]{8});
        FOLLOW_I_PROLOGUE_in_prologue1807 = new BitSet(new long[]{2});
        FOLLOW_I_EPILOGUE_in_epilogue1823 = new BitSet(new long[]{2});
        FOLLOW_I_SOURCE_in_source1840 = new BitSet(new long[]{4});
        FOLLOW_string_literal_in_source1842 = new BitSet(new long[]{8});
        f4804xd2a85fb2 = new BitSet(new long[]{4});
        FOLLOW_literal_in_call_site_extra_arguments1871 = new BitSet(new long[]{549764307208L, 2181433216991232L, 2341871806232657921L, 8946696});
        FOLLOW_I_ORDERED_METHOD_ITEMS_in_ordered_method_items1887 = new BitSet(new long[]{4});
        FOLLOW_label_def_in_ordered_method_items1890 = new BitSet(new long[]{8, 2024368032503037952L, 36028797018943744L});
        FOLLOW_instruction_in_ordered_method_items1894 = new BitSet(new long[]{8, 2024368032503037952L, 36028797018943744L});
        FOLLOW_debug_directive_in_ordered_method_items1898 = new BitSet(new long[]{8, 2024368032503037952L, 36028797018943744L});
        FOLLOW_SIMPLE_NAME_in_label_ref1914 = new BitSet(new long[]{2});
        FOLLOW_I_REGISTER_LIST_in_register_list1939 = new BitSet(new long[]{4});
        FOLLOW_REGISTER_in_register_list1948 = new BitSet(new long[]{8, 0, 0, PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM});
        FOLLOW_I_REGISTER_RANGE_in_register_range1973 = new BitSet(new long[]{4});
        FOLLOW_REGISTER_in_register_range1978 = new BitSet(new long[]{8, 0, 0, PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM});
        FOLLOW_REGISTER_in_register_range1982 = new BitSet(new long[]{8});
        FOLLOW_CLASS_DESCRIPTOR_in_verification_error_reference2005 = new BitSet(new long[]{2});
        FOLLOW_field_reference_in_verification_error_reference2015 = new BitSet(new long[]{2});
        FOLLOW_method_reference_in_verification_error_reference2025 = new BitSet(new long[]{2});
        FOLLOW_VERIFICATION_ERROR_TYPE_in_verification_error_type2042 = new BitSet(new long[]{2});
        FOLLOW_insn_format10t_in_instruction2056 = new BitSet(new long[]{2});
        FOLLOW_insn_format10x_in_instruction2062 = new BitSet(new long[]{2});
        FOLLOW_insn_format11n_in_instruction2068 = new BitSet(new long[]{2});
        FOLLOW_insn_format11x_in_instruction2074 = new BitSet(new long[]{2});
        FOLLOW_insn_format12x_in_instruction2080 = new BitSet(new long[]{2});
        FOLLOW_insn_format20bc_in_instruction2086 = new BitSet(new long[]{2});
        FOLLOW_insn_format20t_in_instruction2092 = new BitSet(new long[]{2});
        FOLLOW_insn_format21c_field_in_instruction2098 = new BitSet(new long[]{2});
        FOLLOW_insn_format21c_method_handle_in_instruction2104 = new BitSet(new long[]{2});
        FOLLOW_insn_format21c_method_type_in_instruction2110 = new BitSet(new long[]{2});
        FOLLOW_insn_format21c_string_in_instruction2116 = new BitSet(new long[]{2});
        FOLLOW_insn_format21c_type_in_instruction2122 = new BitSet(new long[]{2});
        FOLLOW_insn_format21ih_in_instruction2128 = new BitSet(new long[]{2});
        FOLLOW_insn_format21lh_in_instruction2134 = new BitSet(new long[]{2});
        FOLLOW_insn_format21s_in_instruction2140 = new BitSet(new long[]{2});
        FOLLOW_insn_format21t_in_instruction2146 = new BitSet(new long[]{2});
        FOLLOW_insn_format22b_in_instruction2152 = new BitSet(new long[]{2});
        FOLLOW_insn_format22c_field_in_instruction2158 = new BitSet(new long[]{2});
        FOLLOW_insn_format22c_type_in_instruction2164 = new BitSet(new long[]{2});
        FOLLOW_insn_format22s_in_instruction2170 = new BitSet(new long[]{2});
        FOLLOW_insn_format22t_in_instruction2176 = new BitSet(new long[]{2});
        FOLLOW_insn_format22x_in_instruction2182 = new BitSet(new long[]{2});
        FOLLOW_insn_format23x_in_instruction2188 = new BitSet(new long[]{2});
        FOLLOW_insn_format30t_in_instruction2194 = new BitSet(new long[]{2});
        FOLLOW_insn_format31c_in_instruction2200 = new BitSet(new long[]{2});
        FOLLOW_insn_format31i_in_instruction2206 = new BitSet(new long[]{2});
        FOLLOW_insn_format31t_in_instruction2212 = new BitSet(new long[]{2});
        FOLLOW_insn_format32x_in_instruction2218 = new BitSet(new long[]{2});
        FOLLOW_insn_format35c_call_site_in_instruction2224 = new BitSet(new long[]{2});
        FOLLOW_insn_format35c_method_in_instruction2230 = new BitSet(new long[]{2});
        FOLLOW_insn_format35c_type_in_instruction2236 = new BitSet(new long[]{2});
        FOLLOW_insn_format3rc_call_site_in_instruction2242 = new BitSet(new long[]{2});
        FOLLOW_insn_format3rc_method_in_instruction2248 = new BitSet(new long[]{2});
        FOLLOW_insn_format3rc_type_in_instruction2254 = new BitSet(new long[]{2});
        FOLLOW_insn_format45cc_method_in_instruction2260 = new BitSet(new long[]{2});
        FOLLOW_insn_format4rcc_method_in_instruction2266 = new BitSet(new long[]{2});
        FOLLOW_insn_format51l_type_in_instruction2272 = new BitSet(new long[]{2});
        FOLLOW_insn_array_data_directive_in_instruction2278 = new BitSet(new long[]{2});
        FOLLOW_insn_packed_switch_directive_in_instruction2284 = new BitSet(new long[]{2});
        FOLLOW_insn_sparse_switch_directive_in_instruction2290 = new BitSet(new long[]{2});
        FOLLOW_I_STATEMENT_FORMAT10t_in_insn_format10t2314 = new BitSet(new long[]{4});
        FOLLOW_INSTRUCTION_FORMAT10t_in_insn_format10t2316 = new BitSet(new long[]{0, 0, 0, PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH});
        FOLLOW_label_ref_in_insn_format10t2318 = new BitSet(new long[]{8});
        FOLLOW_I_STATEMENT_FORMAT10x_in_insn_format10x2341 = new BitSet(new long[]{4});
        FOLLOW_INSTRUCTION_FORMAT10x_in_insn_format10x2343 = new BitSet(new long[]{8});
        FOLLOW_I_STATEMENT_FORMAT11n_in_insn_format11n2366 = new BitSet(new long[]{4});
        FOLLOW_INSTRUCTION_FORMAT11n_in_insn_format11n2368 = new BitSet(new long[]{0, 0, 0, PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM});
        FOLLOW_REGISTER_in_insn_format11n2370 = new BitSet(new long[]{36864, 2147483648L, 2305843009213693952L, PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID});
        FOLLOW_short_integral_literal_in_insn_format11n2372 = new BitSet(new long[]{8});
        FOLLOW_I_STATEMENT_FORMAT11x_in_insn_format11x2395 = new BitSet(new long[]{4});
        FOLLOW_INSTRUCTION_FORMAT11x_in_insn_format11x2397 = new BitSet(new long[]{0, 0, 0, PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM});
        FOLLOW_REGISTER_in_insn_format11x2399 = new BitSet(new long[]{8});
        FOLLOW_I_STATEMENT_FORMAT12x_in_insn_format12x2422 = new BitSet(new long[]{4});
        FOLLOW_INSTRUCTION_FORMAT12x_in_insn_format12x2424 = new BitSet(new long[]{0, 0, 0, PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM});
        FOLLOW_REGISTER_in_insn_format12x2428 = new BitSet(new long[]{0, 0, 0, PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM});
        FOLLOW_REGISTER_in_insn_format12x2432 = new BitSet(new long[]{8});
        FOLLOW_I_STATEMENT_FORMAT20bc_in_insn_format20bc2455 = new BitSet(new long[]{4});
        FOLLOW_INSTRUCTION_FORMAT20bc_in_insn_format20bc2457 = new BitSet(new long[]{0, 0, 0, 4194304});
        FOLLOW_verification_error_type_in_insn_format20bc2459 = new BitSet(new long[]{65792, 0, 0, PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH});
        FOLLOW_verification_error_reference_in_insn_format20bc2461 = new BitSet(new long[]{8});
        FOLLOW_I_STATEMENT_FORMAT20t_in_insn_format20t2484 = new BitSet(new long[]{4});
        FOLLOW_INSTRUCTION_FORMAT20t_in_insn_format20t2486 = new BitSet(new long[]{0, 0, 0, PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH});
        FOLLOW_label_ref_in_insn_format20t2488 = new BitSet(new long[]{8});
        FOLLOW_I_STATEMENT_FORMAT21c_FIELD_in_insn_format21c_field2511 = new BitSet(new long[]{4});
        new BitSet(new long[]{0, 0, 0, PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM});
        FOLLOW_REGISTER_in_insn_format21c_field2523 = new BitSet(new long[]{65792, 0, 0, PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH});
        FOLLOW_field_reference_in_insn_format21c_field2525 = new BitSet(new long[]{8});
        f4806x73619f17 = new BitSet(new long[]{4});
        f4797x8b66dd46 = new BitSet(new long[]{0, 0, 0, PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM});
        FOLLOW_REGISTER_in_insn_format21c_method_handle2556 = new BitSet(new long[]{0, PlaybackStateCompat.ACTION_SET_REPEAT_MODE, 0, 3});
        f4814xd17b2dfa = new BitSet(new long[]{8});
        f4807x74980830 = new BitSet(new long[]{4});
        f4798xcbb198ca = new BitSet(new long[]{0, 0, 0, PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM});
        FOLLOW_REGISTER_in_insn_format21c_method_type2589 = new BitSet(new long[]{0, 0, 1});
        FOLLOW_method_prototype_in_insn_format21c_method_type2591 = new BitSet(new long[]{8});
        FOLLOW_I_STATEMENT_FORMAT21c_STRING_in_insn_format21c_string2614 = new BitSet(new long[]{4});
        FOLLOW_INSTRUCTION_FORMAT21c_STRING_in_insn_format21c_string2616 = new BitSet(new long[]{0, 0, 0, PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM});
        FOLLOW_REGISTER_in_insn_format21c_string2618 = new BitSet(new long[]{0, 0, 0, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED});
        FOLLOW_string_literal_in_insn_format21c_string2620 = new BitSet(new long[]{8});
        FOLLOW_I_STATEMENT_FORMAT21c_TYPE_in_insn_format21c_type2643 = new BitSet(new long[]{4});
        FOLLOW_INSTRUCTION_FORMAT21c_TYPE_in_insn_format21c_type2645 = new BitSet(new long[]{0, 0, 0, PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM});
        FOLLOW_REGISTER_in_insn_format21c_type2647 = new BitSet(new long[]{65792, 0, 0, PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID});
        FOLLOW_nonvoid_type_descriptor_in_insn_format21c_type2649 = new BitSet(new long[]{8});
        FOLLOW_I_STATEMENT_FORMAT21ih_in_insn_format21ih2672 = new BitSet(new long[]{4});
        FOLLOW_INSTRUCTION_FORMAT21ih_in_insn_format21ih2674 = new BitSet(new long[]{0, 0, 0, PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM});
        FOLLOW_REGISTER_in_insn_format21ih2676 = new BitSet(new long[]{549755852800L, 2147483648L, 2305843009213693952L, PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID});
        FOLLOW_fixed_32bit_literal_in_insn_format21ih2678 = new BitSet(new long[]{8});
        FOLLOW_I_STATEMENT_FORMAT21lh_in_insn_format21lh2701 = new BitSet(new long[]{4});
        FOLLOW_INSTRUCTION_FORMAT21lh_in_insn_format21lh2703 = new BitSet(new long[]{0, 0, 0, PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM});
        FOLLOW_REGISTER_in_insn_format21lh2705 = new BitSet(new long[]{549764241408L, 2147483648L, 2305843009213693952L, PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID});
        FOLLOW_fixed_64bit_literal_in_insn_format21lh2707 = new BitSet(new long[]{8});
        FOLLOW_I_STATEMENT_FORMAT21s_in_insn_format21s2730 = new BitSet(new long[]{4});
        FOLLOW_INSTRUCTION_FORMAT21s_in_insn_format21s2732 = new BitSet(new long[]{0, 0, 0, PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM});
        FOLLOW_REGISTER_in_insn_format21s2734 = new BitSet(new long[]{36864, 2147483648L, 2305843009213693952L, PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID});
        FOLLOW_short_integral_literal_in_insn_format21s2736 = new BitSet(new long[]{8});
        FOLLOW_I_STATEMENT_FORMAT21t_in_insn_format21t2759 = new BitSet(new long[]{4});
        FOLLOW_INSTRUCTION_FORMAT21t_in_insn_format21t2761 = new BitSet(new long[]{0, 0, 0, PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM});
        FOLLOW_REGISTER_in_insn_format21t2763 = new BitSet(new long[]{0, 0, 0, PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH});
        FOLLOW_label_ref_in_insn_format21t2765 = new BitSet(new long[]{8});
        FOLLOW_I_STATEMENT_FORMAT22b_in_insn_format22b2788 = new BitSet(new long[]{4});
        FOLLOW_INSTRUCTION_FORMAT22b_in_insn_format22b2790 = new BitSet(new long[]{0, 0, 0, PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM});
        FOLLOW_REGISTER_in_insn_format22b2794 = new BitSet(new long[]{0, 0, 0, PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM});
        FOLLOW_REGISTER_in_insn_format22b2798 = new BitSet(new long[]{36864, 2147483648L, 2305843009213693952L, PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID});
        FOLLOW_short_integral_literal_in_insn_format22b2800 = new BitSet(new long[]{8});
        FOLLOW_I_STATEMENT_FORMAT22c_FIELD_in_insn_format22c_field2823 = new BitSet(new long[]{4});
        new BitSet(new long[]{0, 0, 0, PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM});
        FOLLOW_REGISTER_in_insn_format22c_field2837 = new BitSet(new long[]{0, 0, 0, PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM});
        FOLLOW_REGISTER_in_insn_format22c_field2841 = new BitSet(new long[]{65792, 0, 0, PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH});
        FOLLOW_field_reference_in_insn_format22c_field2843 = new BitSet(new long[]{8});
        FOLLOW_I_STATEMENT_FORMAT22c_TYPE_in_insn_format22c_type2866 = new BitSet(new long[]{4});
        FOLLOW_INSTRUCTION_FORMAT22c_TYPE_in_insn_format22c_type2868 = new BitSet(new long[]{0, 0, 0, PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM});
        FOLLOW_REGISTER_in_insn_format22c_type2872 = new BitSet(new long[]{0, 0, 0, PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM});
        FOLLOW_REGISTER_in_insn_format22c_type2876 = new BitSet(new long[]{65792, 0, 0, PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID});
        FOLLOW_nonvoid_type_descriptor_in_insn_format22c_type2878 = new BitSet(new long[]{8});
        FOLLOW_I_STATEMENT_FORMAT22s_in_insn_format22s2901 = new BitSet(new long[]{4});
        FOLLOW_INSTRUCTION_FORMAT22s_in_insn_format22s2903 = new BitSet(new long[]{0, 0, 0, PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM});
        FOLLOW_REGISTER_in_insn_format22s2907 = new BitSet(new long[]{0, 0, 0, PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM});
        FOLLOW_REGISTER_in_insn_format22s2911 = new BitSet(new long[]{36864, 2147483648L, 2305843009213693952L, PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID});
        FOLLOW_short_integral_literal_in_insn_format22s2913 = new BitSet(new long[]{8});
        FOLLOW_I_STATEMENT_FORMAT22t_in_insn_format22t2936 = new BitSet(new long[]{4});
        FOLLOW_INSTRUCTION_FORMAT22t_in_insn_format22t2938 = new BitSet(new long[]{0, 0, 0, PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM});
        FOLLOW_REGISTER_in_insn_format22t2942 = new BitSet(new long[]{0, 0, 0, PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM});
        FOLLOW_REGISTER_in_insn_format22t2946 = new BitSet(new long[]{0, 0, 0, PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH});
        FOLLOW_label_ref_in_insn_format22t2948 = new BitSet(new long[]{8});
        FOLLOW_I_STATEMENT_FORMAT22x_in_insn_format22x2971 = new BitSet(new long[]{4});
        FOLLOW_INSTRUCTION_FORMAT22x_in_insn_format22x2973 = new BitSet(new long[]{0, 0, 0, PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM});
        FOLLOW_REGISTER_in_insn_format22x2977 = new BitSet(new long[]{0, 0, 0, PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM});
        FOLLOW_REGISTER_in_insn_format22x2981 = new BitSet(new long[]{8});
        FOLLOW_I_STATEMENT_FORMAT23x_in_insn_format23x3004 = new BitSet(new long[]{4});
        FOLLOW_INSTRUCTION_FORMAT23x_in_insn_format23x3006 = new BitSet(new long[]{0, 0, 0, PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM});
        FOLLOW_REGISTER_in_insn_format23x3010 = new BitSet(new long[]{0, 0, 0, PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM});
        FOLLOW_REGISTER_in_insn_format23x3014 = new BitSet(new long[]{0, 0, 0, PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM});
        FOLLOW_REGISTER_in_insn_format23x3018 = new BitSet(new long[]{8});
        FOLLOW_I_STATEMENT_FORMAT30t_in_insn_format30t3041 = new BitSet(new long[]{4});
        FOLLOW_INSTRUCTION_FORMAT30t_in_insn_format30t3043 = new BitSet(new long[]{0, 0, 0, PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH});
        FOLLOW_label_ref_in_insn_format30t3045 = new BitSet(new long[]{8});
        FOLLOW_I_STATEMENT_FORMAT31c_in_insn_format31c3068 = new BitSet(new long[]{4});
        FOLLOW_INSTRUCTION_FORMAT31c_in_insn_format31c3070 = new BitSet(new long[]{0, 0, 0, PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM});
        FOLLOW_REGISTER_in_insn_format31c3072 = new BitSet(new long[]{0, 0, 0, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED});
        FOLLOW_string_literal_in_insn_format31c3074 = new BitSet(new long[]{8});
        FOLLOW_I_STATEMENT_FORMAT31i_in_insn_format31i3097 = new BitSet(new long[]{4});
        FOLLOW_INSTRUCTION_FORMAT31i_in_insn_format31i3099 = new BitSet(new long[]{0, 0, 0, PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM});
        FOLLOW_REGISTER_in_insn_format31i3101 = new BitSet(new long[]{549755852800L, 2147483648L, 2305843009213693952L, PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID});
        FOLLOW_fixed_32bit_literal_in_insn_format31i3103 = new BitSet(new long[]{8});
        FOLLOW_I_STATEMENT_FORMAT31t_in_insn_format31t3126 = new BitSet(new long[]{4});
        FOLLOW_INSTRUCTION_FORMAT31t_in_insn_format31t3128 = new BitSet(new long[]{0, 0, 0, PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM});
        FOLLOW_REGISTER_in_insn_format31t3130 = new BitSet(new long[]{0, 0, 0, PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH});
        FOLLOW_label_ref_in_insn_format31t3132 = new BitSet(new long[]{8});
        FOLLOW_I_STATEMENT_FORMAT32x_in_insn_format32x3155 = new BitSet(new long[]{4});
        FOLLOW_INSTRUCTION_FORMAT32x_in_insn_format32x3157 = new BitSet(new long[]{0, 0, 0, PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM});
        FOLLOW_REGISTER_in_insn_format32x3161 = new BitSet(new long[]{0, 0, 0, PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM});
        FOLLOW_REGISTER_in_insn_format32x3165 = new BitSet(new long[]{8});
        f4808x5b268606 = new BitSet(new long[]{4});
        f4799x5961a91d = new BitSet(new long[]{0, 0, PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID});
        FOLLOW_register_list_in_insn_format35c_call_site3197 = new BitSet(new long[]{0, 2199023255552L});
        FOLLOW_call_site_reference_in_insn_format35c_call_site3199 = new BitSet(new long[]{8});
        FOLLOW_I_STATEMENT_FORMAT35c_METHOD_in_insn_format35c_method3222 = new BitSet(new long[]{4});
        FOLLOW_INSTRUCTION_FORMAT35c_METHOD_in_insn_format35c_method3224 = new BitSet(new long[]{0, 0, PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID});
        FOLLOW_register_list_in_insn_format35c_method3226 = new BitSet(new long[]{65792, 0, 0, PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH});
        FOLLOW_method_reference_in_insn_format35c_method3228 = new BitSet(new long[]{8});
        FOLLOW_I_STATEMENT_FORMAT35c_TYPE_in_insn_format35c_type3251 = new BitSet(new long[]{4});
        FOLLOW_INSTRUCTION_FORMAT35c_TYPE_in_insn_format35c_type3253 = new BitSet(new long[]{0, 0, PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID});
        FOLLOW_register_list_in_insn_format35c_type3255 = new BitSet(new long[]{65792, 0, 0, PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID});
        FOLLOW_nonvoid_type_descriptor_in_insn_format35c_type3257 = new BitSet(new long[]{8});
        f4809x8d3d8370 = new BitSet(new long[]{4});
        f4800x8b78a687 = new BitSet(new long[]{0, 0, PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH});
        FOLLOW_register_range_in_insn_format3rc_call_site3289 = new BitSet(new long[]{0, 2199023255552L});
        FOLLOW_call_site_reference_in_insn_format3rc_call_site3291 = new BitSet(new long[]{8});
        FOLLOW_I_STATEMENT_FORMAT3rc_METHOD_in_insn_format3rc_method3314 = new BitSet(new long[]{4});
        FOLLOW_INSTRUCTION_FORMAT3rc_METHOD_in_insn_format3rc_method3316 = new BitSet(new long[]{0, 0, PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH});
        FOLLOW_register_range_in_insn_format3rc_method3318 = new BitSet(new long[]{65792, 0, 0, PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH});
        FOLLOW_method_reference_in_insn_format3rc_method3320 = new BitSet(new long[]{8});
        FOLLOW_I_STATEMENT_FORMAT3rc_TYPE_in_insn_format3rc_type3343 = new BitSet(new long[]{4});
        FOLLOW_INSTRUCTION_FORMAT3rc_TYPE_in_insn_format3rc_type3345 = new BitSet(new long[]{0, 0, PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH});
        FOLLOW_register_range_in_insn_format3rc_type3347 = new BitSet(new long[]{65792, 0, 0, PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID});
        FOLLOW_nonvoid_type_descriptor_in_insn_format3rc_type3349 = new BitSet(new long[]{8});
        f4810x586fb6b3 = new BitSet(new long[]{4});
        f4801xfe79ac4a = new BitSet(new long[]{0, 0, PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID});
        FOLLOW_register_list_in_insn_format45cc_method3376 = new BitSet(new long[]{65792, 0, 0, PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH});
        FOLLOW_method_reference_in_insn_format45cc_method3378 = new BitSet(new long[]{0, 0, 1});
        FOLLOW_method_prototype_in_insn_format45cc_method3380 = new BitSet(new long[]{8});
        f4811xec6b29a2 = new BitSet(new long[]{4});
        f4802x92751f39 = new BitSet(new long[]{0, 0, PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH});
        FOLLOW_register_range_in_insn_format4rcc_method3407 = new BitSet(new long[]{65792, 0, 0, PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH});
        FOLLOW_method_reference_in_insn_format4rcc_method3409 = new BitSet(new long[]{0, 0, 1});
        FOLLOW_method_prototype_in_insn_format4rcc_method3411 = new BitSet(new long[]{8});
        FOLLOW_I_STATEMENT_FORMAT51l_in_insn_format51l_type3434 = new BitSet(new long[]{4});
        FOLLOW_INSTRUCTION_FORMAT51l_in_insn_format51l_type3436 = new BitSet(new long[]{0, 0, 0, PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM});
        FOLLOW_REGISTER_in_insn_format51l_type3438 = new BitSet(new long[]{549764241408L, 2147483648L, 2305843009213693952L, PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID});
        FOLLOW_fixed_64bit_literal_in_insn_format51l_type3440 = new BitSet(new long[]{8});
        FOLLOW_I_STATEMENT_ARRAY_DATA_in_insn_array_data_directive3463 = new BitSet(new long[]{4});
        FOLLOW_I_ARRAY_ELEMENT_SIZE_in_insn_array_data_directive3466 = new BitSet(new long[]{4});
        FOLLOW_short_integral_literal_in_insn_array_data_directive3468 = new BitSet(new long[]{8});
        FOLLOW_array_elements_in_insn_array_data_directive3471 = new BitSet(new long[]{8});
        f4812x8c53fca9 = new BitSet(new long[]{4});
        f4805x4c89fb9f = new BitSet(new long[]{4});
        FOLLOW_fixed_32bit_literal_in_insn_packed_switch_directive3498 = new BitSet(new long[]{8});
        f4815xf8430993 = new BitSet(new long[]{8});
        f4813x856d6443 = new BitSet(new long[]{4});
        f4816x24e99ed7 = new BitSet(new long[]{8});
        FOLLOW_ARRAY_TYPE_PREFIX_in_array_descriptor3548 = new BitSet(new long[]{PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH, 0, 0, PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID});
        FOLLOW_PRIMITIVE_TYPE_in_array_descriptor3552 = new BitSet(new long[]{2});
        FOLLOW_CLASS_DESCRIPTOR_in_array_descriptor3580 = new BitSet(new long[]{2});
        FOLLOW_PRIMITIVE_TYPE_in_nonvoid_type_descriptor3598 = new BitSet(new long[]{2});
        FOLLOW_CLASS_DESCRIPTOR_in_nonvoid_type_descriptor3606 = new BitSet(new long[]{2});
        FOLLOW_array_descriptor_in_nonvoid_type_descriptor3614 = new BitSet(new long[]{2});
        FOLLOW_CLASS_DESCRIPTOR_in_reference_type_descriptor3635 = new BitSet(new long[]{2});
        FOLLOW_array_descriptor_in_reference_type_descriptor3643 = new BitSet(new long[]{2});
        FOLLOW_VOID_TYPE_in_type_descriptor3663 = new BitSet(new long[]{2});
        FOLLOW_nonvoid_type_descriptor_in_type_descriptor3671 = new BitSet(new long[]{2});
        FOLLOW_long_literal_in_short_integral_literal3689 = new BitSet(new long[]{2});
        FOLLOW_integer_literal_in_short_integral_literal3701 = new BitSet(new long[]{2});
        FOLLOW_short_literal_in_short_integral_literal3713 = new BitSet(new long[]{2});
        FOLLOW_char_literal_in_short_integral_literal3721 = new BitSet(new long[]{2});
        FOLLOW_byte_literal_in_short_integral_literal3729 = new BitSet(new long[]{2});
        FOLLOW_long_literal_in_integral_literal3744 = new BitSet(new long[]{2});
        FOLLOW_integer_literal_in_integral_literal3756 = new BitSet(new long[]{2});
        FOLLOW_short_literal_in_integral_literal3764 = new BitSet(new long[]{2});
        FOLLOW_byte_literal_in_integral_literal3772 = new BitSet(new long[]{2});
        FOLLOW_INTEGER_LITERAL_in_integer_literal3788 = new BitSet(new long[]{2});
        FOLLOW_LONG_LITERAL_in_long_literal3803 = new BitSet(new long[]{2});
        FOLLOW_SHORT_LITERAL_in_short_literal3818 = new BitSet(new long[]{2});
        FOLLOW_BYTE_LITERAL_in_byte_literal3833 = new BitSet(new long[]{2});
        FOLLOW_FLOAT_LITERAL_in_float_literal3848 = new BitSet(new long[]{2});
        FOLLOW_DOUBLE_LITERAL_in_double_literal3863 = new BitSet(new long[]{2});
        FOLLOW_CHAR_LITERAL_in_char_literal3878 = new BitSet(new long[]{2});
        FOLLOW_STRING_LITERAL_in_string_literal3893 = new BitSet(new long[]{2});
        FOLLOW_BOOL_LITERAL_in_bool_literal3912 = new BitSet(new long[]{2});
        FOLLOW_I_ENCODED_ARRAY_in_array_literal3934 = new BitSet(new long[]{4});
        FOLLOW_literal_in_array_literal3937 = new BitSet(new long[]{549764307208L, 2181433216991232L, 2341871806232657921L, 8946696});
        FOLLOW_I_ANNOTATIONS_in_annotations3962 = new BitSet(new long[]{4});
        FOLLOW_annotation_in_annotations3965 = new BitSet(new long[]{8, 34359738368L});
        FOLLOW_I_ANNOTATION_in_annotation3994 = new BitSet(new long[]{4});
        FOLLOW_ANNOTATION_VISIBILITY_in_annotation3996 = new BitSet(new long[]{0, 0, 36028797018963968L});
        FOLLOW_subannotation_in_annotation3998 = new BitSet(new long[]{8});
        FOLLOW_I_ANNOTATION_ELEMENT_in_annotation_element4019 = new BitSet(new long[]{4});
        FOLLOW_SIMPLE_NAME_in_annotation_element4021 = new BitSet(new long[]{549764307200L, 2181433216991232L, 2341871806232657921L, 8946696});
        FOLLOW_literal_in_annotation_element4023 = new BitSet(new long[]{8});
        FOLLOW_I_SUBANNOTATION_in_subannotation4050 = new BitSet(new long[]{4});
        FOLLOW_CLASS_DESCRIPTOR_in_subannotation4060 = new BitSet(new long[]{8, 137438953472L});
        FOLLOW_annotation_element_in_subannotation4071 = new BitSet(new long[]{8, 137438953472L});
        FOLLOW_I_ENCODED_FIELD_in_field_literal4110 = new BitSet(new long[]{4});
        FOLLOW_field_reference_in_field_literal4112 = new BitSet(new long[]{8});
        FOLLOW_I_ENCODED_METHOD_in_method_literal4133 = new BitSet(new long[]{4});
        FOLLOW_method_reference_in_method_literal4135 = new BitSet(new long[]{8});
        FOLLOW_I_ENCODED_ENUM_in_enum_literal4156 = new BitSet(new long[]{4});
        FOLLOW_field_reference_in_enum_literal4158 = new BitSet(new long[]{8});
    }

    public smaliTreeWalker(TreeNodeStream treeNodeStream) {
        this(treeNodeStream, new RecognizerSharedState());
    }

    public smaliTreeWalker(TreeNodeStream treeNodeStream, RecognizerSharedState recognizerSharedState) {
        super(treeNodeStream, recognizerSharedState);
        this.verboseErrors = false;
        this.apiLevel = 15;
        this.opcodes = Opcodes.forApi(15);
        this.errMessages = "";
        this.method_stack = new Stack<>();
    }

    public final int access_list() throws RecognitionException {
        int value = 0;
        try {
            match(this.input, 97, FOLLOW_I_ACCESS_LIST_in_access_list247);
            if (this.input.mo3787LA(1) == 2) {
                match(this.input, 2, null);
                while (true) {
                    if ((this.input.mo3787LA(1) == 4 ? (char) 1 : (char) 2) != 1) {
                        break;
                    }
                    value |= AccessFlags.getAccessFlag(((CommonTree) match(this.input, 4, FOLLOW_ACCESS_SPEC_in_access_list265)).getText()).getValue();
                }
                match(this.input, 3, null);
            }
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
        }
        return value;
    }

    public final access_or_restriction_list_return access_or_restriction_list() throws RecognitionException {
        access_or_restriction_list_return access_or_restriction_list_returnVar = new access_or_restriction_list_return();
        access_or_restriction_list_returnVar.start = this.input.m3792LT(1);
        access_or_restriction_list_returnVar.value = 0;
        ArrayList arrayList = new ArrayList();
        try {
            match(this.input, 98, f4803xc8f81cb8);
            HiddenApiRestriction hiddenApiRestriction = null;
            if (this.input.mo3787LA(1) == 2) {
                match(this.input, 2, null);
                HiddenApiRestriction hiddenApiRestriction2 = null;
                while (true) {
                    int iMo3787LA = this.input.mo3787LA(1);
                    char c = iMo3787LA == 4 ? (char) 1 : iMo3787LA == 41 ? (char) 2 : (char) 3;
                    if (c == 1) {
                        access_or_restriction_list_returnVar.value = AccessFlags.getAccessFlag(((CommonTree) match(this.input, 4, FOLLOW_ACCESS_SPEC_in_access_or_restriction_list326)).getText()).getValue() | access_or_restriction_list_returnVar.value;
                    } else {
                        if (c != 2) {
                            match(this.input, 3, null);
                            hiddenApiRestriction = hiddenApiRestriction2;
                            break;
                        }
                        CommonTree commonTree = (CommonTree) match(this.input, 41, FOLLOW_HIDDENAPI_RESTRICTION_in_access_or_restriction_list356);
                        if (this.opcodes.api < 29) {
                            throw new SemanticException(this.input, commonTree, "Hidden API restrictions are only supported on api 29 and above.", new Object[0]);
                        }
                        HiddenApiRestriction hiddenApiRestrictionForName = HiddenApiRestriction.forName(commonTree.getText());
                        if (hiddenApiRestrictionForName.isDomainSpecificApiFlag()) {
                            arrayList.add(hiddenApiRestrictionForName);
                        } else {
                            if (hiddenApiRestriction2 != null) {
                                throw new SemanticException(this.input, commonTree, "Only one hidden api restriction may be specified.", new Object[0]);
                            }
                            hiddenApiRestriction2 = hiddenApiRestrictionForName;
                        }
                    }
                }
            }
            ImmutableSet.Builder builder = ImmutableSet.builder();
            if (hiddenApiRestriction != null) {
                builder.add(hiddenApiRestriction);
            }
            builder.addAll((Iterable) arrayList);
            access_or_restriction_list_returnVar.hiddenApiRestrictions = builder.build();
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
        }
        return access_or_restriction_list_returnVar;
    }

    public final Annotation annotation() throws RecognitionException {
        try {
            match(this.input, 99, FOLLOW_I_ANNOTATION_in_annotation3994);
            match(this.input, 2, null);
            CommonTree commonTree = (CommonTree) match(this.input, 6, FOLLOW_ANNOTATION_VISIBILITY_in_annotation3996);
            pushFollow(FOLLOW_subannotation_in_annotation3998);
            subannotation_return subannotation_returnVarSubannotation = subannotation();
            RecognizerSharedState recognizerSharedState = this.state;
            recognizerSharedState._fsp--;
            match(this.input, 3, null);
            return new ImmutableAnnotation(AnnotationVisibility.getVisibility(commonTree != null ? commonTree.getText() : null), subannotation_returnVarSubannotation != null ? subannotation_returnVarSubannotation.annotationType : null, subannotation_returnVarSubannotation != null ? subannotation_returnVarSubannotation.elements : null);
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
            return null;
        }
    }

    public final AnnotationElement annotation_element() throws RecognitionException {
        try {
            match(this.input, C0299R.styleable.AppCompatTheme_buttonBarNegativeButtonStyle, FOLLOW_I_ANNOTATION_ELEMENT_in_annotation_element4019);
            match(this.input, 2, null);
            CommonTree commonTree = (CommonTree) match(this.input, 208, FOLLOW_SIMPLE_NAME_in_annotation_element4021);
            pushFollow(FOLLOW_literal_in_annotation_element4023);
            ImmutableEncodedValue immutableEncodedValueLiteral = literal();
            RecognizerSharedState recognizerSharedState = this.state;
            recognizerSharedState._fsp--;
            match(this.input, 3, null);
            return new ImmutableAnnotationElement(commonTree != null ? commonTree.getText() : null, immutableEncodedValueLiteral);
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
            return null;
        }
    }

    public final Set<Annotation> annotations() throws RecognitionException {
        Annotation annotation;
        try {
            HashMap mapNewHashMap = Maps.newHashMap();
            match(this.input, 100, FOLLOW_I_ANNOTATIONS_in_annotations3962);
            if (this.input.mo3787LA(1) == 2) {
                match(this.input, 2, null);
                do {
                    if ((this.input.mo3787LA(1) == 99 ? (char) 1 : (char) 2) != 1) {
                        match(this.input, 3, null);
                    } else {
                        pushFollow(FOLLOW_annotation_in_annotations3965);
                        annotation = annotation();
                        this.state._fsp--;
                    }
                } while (((Annotation) mapNewHashMap.put(annotation.getType(), annotation)) == null);
                throw new SemanticException(this.input, "Multiple annotations of type %s", annotation.getType());
            }
            return ImmutableSet.copyOf(mapNewHashMap.values());
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
            return null;
        }
    }

    public final String array_descriptor() throws RecognitionException {
        char c;
        try {
            CommonTree commonTree = (CommonTree) match(this.input, 8, FOLLOW_ARRAY_TYPE_PREFIX_in_array_descriptor3548);
            int iMo3787LA = this.input.mo3787LA(1);
            if (iMo3787LA == 202) {
                c = 1;
            } else {
                if (iMo3787LA != 16) {
                    throw new NoViableAltException("", 40, 0, this.input);
                }
                c = 2;
            }
            if (c == 1) {
                CommonTree commonTree2 = (CommonTree) match(this.input, 202, FOLLOW_PRIMITIVE_TYPE_in_array_descriptor3552);
                StringBuilder sb = new StringBuilder();
                sb.append(commonTree != null ? commonTree.getText() : null);
                sb.append(commonTree2 != null ? commonTree2.getText() : null);
                return sb.toString();
            }
            if (c != 2) {
                return null;
            }
            CommonTree commonTree3 = (CommonTree) match(this.input, 16, FOLLOW_CLASS_DESCRIPTOR_in_array_descriptor3580);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(commonTree != null ? commonTree.getText() : null);
            sb2.append(commonTree3 != null ? commonTree3.getText() : null);
            return sb2.toString();
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
            return null;
        }
    }

    public final List<Number> array_elements() throws RecognitionException {
        ArrayList arrayListNewArrayList;
        RecognitionException e;
        try {
            arrayListNewArrayList = Lists.newArrayList();
        } catch (RecognitionException e2) {
            arrayListNewArrayList = null;
            e = e2;
        }
        try {
            match(this.input, C0299R.styleable.AppCompatTheme_buttonBarNeutralButtonStyle, FOLLOW_I_ARRAY_ELEMENTS_in_array_elements905);
            if (this.input.mo3787LA(1) == 2) {
                match(this.input, 2, null);
                while (true) {
                    int iMo3787LA = this.input.mo3787LA(1);
                    if ((((iMo3787LA >= 11 && iMo3787LA <= 12) || iMo3787LA == 15 || iMo3787LA == 23 || iMo3787LA == 39 || iMo3787LA == 95 || iMo3787LA == 189 || iMo3787LA == 207) ? (char) 1 : (char) 2) != 1) {
                        break;
                    }
                    pushFollow(FOLLOW_fixed_64bit_literal_number_in_array_elements914);
                    Number numberFixed_64bit_literal_number = fixed_64bit_literal_number();
                    this.state._fsp--;
                    arrayListNewArrayList.add(numberFixed_64bit_literal_number);
                }
                match(this.input, 3, null);
            }
        } catch (RecognitionException e3) {
            e = e3;
            reportError(e);
            recover(this.input, e);
        }
        return arrayListNewArrayList;
    }

    public final List<EncodedValue> array_literal() throws RecognitionException {
        ArrayList arrayListNewArrayList;
        RecognitionException e;
        try {
            arrayListNewArrayList = Lists.newArrayList();
            try {
                match(this.input, C0299R.styleable.AppCompatTheme_ratingBarStyle, FOLLOW_I_ENCODED_ARRAY_in_array_literal3934);
                if (this.input.mo3787LA(1) == 2) {
                    match(this.input, 2, null);
                    while (true) {
                        int iMo3787LA = this.input.mo3787LA(1);
                        if (((iMo3787LA == 8 || (iMo3787LA >= 11 && iMo3787LA <= 12) || ((iMo3787LA >= 15 && iMo3787LA <= 16) || iMo3787LA == 23 || iMo3787LA == 39 || iMo3787LA == 95 || ((iMo3787LA >= 110 && iMo3787LA <= 114) || iMo3787LA == 128 || iMo3787LA == 183 || iMo3787LA == 189 || iMo3787LA == 195 || iMo3787LA == 202 || iMo3787LA == 207 || iMo3787LA == 211 || iMo3787LA == 215))) ? (char) 1 : (char) 2) != 1) {
                            break;
                        }
                        pushFollow(FOLLOW_literal_in_array_literal3937);
                        ImmutableEncodedValue immutableEncodedValueLiteral = literal();
                        this.state._fsp--;
                        arrayListNewArrayList.add(immutableEncodedValueLiteral);
                    }
                    match(this.input, 3, null);
                }
            } catch (RecognitionException e2) {
                e = e2;
                reportError(e);
                recover(this.input, e);
            }
        } catch (RecognitionException e3) {
            arrayListNewArrayList = null;
            e = e3;
        }
        return arrayListNewArrayList;
    }

    public final boolean bool_literal() throws RecognitionException {
        try {
            CommonTree commonTree = (CommonTree) match(this.input, 11, FOLLOW_BOOL_LITERAL_in_bool_literal3912);
            return Boolean.parseBoolean(commonTree != null ? commonTree.getText() : null);
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
            return false;
        }
    }

    public final byte byte_literal() throws RecognitionException {
        try {
            CommonTree commonTree = (CommonTree) match(this.input, 12, FOLLOW_BYTE_LITERAL_in_byte_literal3833);
            return LiteralTools.parseByte(commonTree != null ? commonTree.getText() : null);
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
            return (byte) 0;
        }
    }

    public final List<ImmutableEncodedValue> call_site_extra_arguments() throws RecognitionException {
        ArrayList arrayListNewArrayList;
        RecognitionException e;
        try {
            arrayListNewArrayList = Lists.newArrayList();
            try {
                match(this.input, C0299R.styleable.AppCompatTheme_buttonStyle, f4804xd2a85fb2);
                if (this.input.mo3787LA(1) == 2) {
                    match(this.input, 2, null);
                    while (true) {
                        int iMo3787LA = this.input.mo3787LA(1);
                        if (((iMo3787LA == 8 || (iMo3787LA >= 11 && iMo3787LA <= 12) || ((iMo3787LA >= 15 && iMo3787LA <= 16) || iMo3787LA == 23 || iMo3787LA == 39 || iMo3787LA == 95 || ((iMo3787LA >= 110 && iMo3787LA <= 114) || iMo3787LA == 128 || iMo3787LA == 183 || iMo3787LA == 189 || iMo3787LA == 195 || iMo3787LA == 202 || iMo3787LA == 207 || iMo3787LA == 211 || iMo3787LA == 215))) ? (char) 1 : (char) 2) != 1) {
                            break;
                        }
                        pushFollow(FOLLOW_literal_in_call_site_extra_arguments1871);
                        ImmutableEncodedValue immutableEncodedValueLiteral = literal();
                        this.state._fsp--;
                        arrayListNewArrayList.add(immutableEncodedValueLiteral);
                    }
                    match(this.input, 3, null);
                }
            } catch (RecognitionException e2) {
                e = e2;
                reportError(e);
                recover(this.input, e);
            }
        } catch (RecognitionException e3) {
            arrayListNewArrayList = null;
            e = e3;
        }
        return arrayListNewArrayList;
    }

    public final ImmutableCallSiteReference call_site_reference() throws RecognitionException {
        try {
            match(this.input, C0299R.styleable.AppCompatTheme_buttonStyleSmall, FOLLOW_I_CALL_SITE_REFERENCE_in_call_site_reference1300);
            match(this.input, 2, null);
            CommonTree commonTree = (CommonTree) match(this.input, 208, FOLLOW_SIMPLE_NAME_in_call_site_reference1304);
            pushFollow(FOLLOW_string_literal_in_call_site_reference1308);
            String strString_literal = string_literal();
            RecognizerSharedState recognizerSharedState = this.state;
            recognizerSharedState._fsp--;
            pushFollow(FOLLOW_method_prototype_in_call_site_reference1310);
            ImmutableMethodProtoReference immutableMethodProtoReferenceMethod_prototype = method_prototype();
            RecognizerSharedState recognizerSharedState2 = this.state;
            recognizerSharedState2._fsp--;
            pushFollow(FOLLOW_call_site_extra_arguments_in_call_site_reference1320);
            List<ImmutableEncodedValue> listCall_site_extra_arguments = call_site_extra_arguments();
            RecognizerSharedState recognizerSharedState3 = this.state;
            recognizerSharedState3._fsp--;
            pushFollow(FOLLOW_method_reference_in_call_site_reference1322);
            ImmutableMethodReference immutableMethodReferenceMethod_reference = method_reference();
            RecognizerSharedState recognizerSharedState4 = this.state;
            recognizerSharedState4._fsp--;
            match(this.input, 3, null);
            return new ImmutableCallSiteReference(commonTree != null ? commonTree.getText() : null, new ImmutableMethodHandleReference(4, immutableMethodReferenceMethod_reference), strString_literal, immutableMethodProtoReferenceMethod_prototype, listCall_site_extra_arguments);
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
            return null;
        }
    }

    public final void catch_directive() throws RecognitionException {
        try {
            match(this.input, C0299R.styleable.AppCompatTheme_checkboxStyle, FOLLOW_I_CATCH_in_catch_directive1558);
            match(this.input, 2, null);
            pushFollow(FOLLOW_nonvoid_type_descriptor_in_catch_directive1560);
            nonvoid_type_descriptor_return nonvoid_type_descriptor_returnVarNonvoid_type_descriptor = nonvoid_type_descriptor();
            RecognizerSharedState recognizerSharedState = this.state;
            recognizerSharedState._fsp--;
            pushFollow(FOLLOW_label_ref_in_catch_directive1564);
            Label labelLabel_ref = label_ref();
            RecognizerSharedState recognizerSharedState2 = this.state;
            recognizerSharedState2._fsp--;
            pushFollow(FOLLOW_label_ref_in_catch_directive1568);
            Label labelLabel_ref2 = label_ref();
            RecognizerSharedState recognizerSharedState3 = this.state;
            recognizerSharedState3._fsp--;
            pushFollow(FOLLOW_label_ref_in_catch_directive1572);
            Label labelLabel_ref3 = label_ref();
            RecognizerSharedState recognizerSharedState4 = this.state;
            recognizerSharedState4._fsp--;
            match(this.input, 3, null);
            this.method_stack.peek().methodBuilder.addCatch(this.dexBuilder.internTypeReference(nonvoid_type_descriptor_returnVarNonvoid_type_descriptor != null ? nonvoid_type_descriptor_returnVarNonvoid_type_descriptor.type : null), labelLabel_ref, labelLabel_ref2, labelLabel_ref3);
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
        }
    }

    public final void catchall_directive() throws RecognitionException {
        try {
            match(this.input, C0299R.styleable.AppCompatTheme_checkedTextViewStyle, FOLLOW_I_CATCHALL_in_catchall_directive1588);
            match(this.input, 2, null);
            pushFollow(FOLLOW_label_ref_in_catchall_directive1592);
            Label labelLabel_ref = label_ref();
            RecognizerSharedState recognizerSharedState = this.state;
            recognizerSharedState._fsp--;
            pushFollow(FOLLOW_label_ref_in_catchall_directive1596);
            Label labelLabel_ref2 = label_ref();
            RecognizerSharedState recognizerSharedState2 = this.state;
            recognizerSharedState2._fsp--;
            pushFollow(FOLLOW_label_ref_in_catchall_directive1600);
            Label labelLabel_ref3 = label_ref();
            RecognizerSharedState recognizerSharedState3 = this.state;
            recognizerSharedState3._fsp--;
            match(this.input, 3, null);
            this.method_stack.peek().methodBuilder.addCatch(labelLabel_ref, labelLabel_ref2, labelLabel_ref3);
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
        }
    }

    public final List<Object> catches() throws RecognitionException {
        ArrayList arrayListNewArrayList = Lists.newArrayList();
        try {
            match(this.input, 108, FOLLOW_I_CATCHES_in_catches1540);
            if (this.input.mo3787LA(1) == 2) {
                match(this.input, 2, null);
                while (true) {
                    if ((this.input.mo3787LA(1) == 106 ? (char) 1 : (char) 2) != 1) {
                        break;
                    }
                    pushFollow(FOLLOW_catch_directive_in_catches1542);
                    catch_directive();
                    this.state._fsp--;
                }
                while (true) {
                    if ((this.input.mo3787LA(1) == 107 ? (char) 1 : (char) 2) != 1) {
                        break;
                    }
                    pushFollow(FOLLOW_catchall_directive_in_catches1545);
                    catchall_directive();
                    this.state._fsp--;
                }
                match(this.input, 3, null);
            }
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
        }
        return arrayListNewArrayList;
    }

    public final char char_literal() throws RecognitionException {
        try {
            CommonTree commonTree = (CommonTree) match(this.input, 15, FOLLOW_CHAR_LITERAL_in_char_literal3878);
            return (commonTree != null ? commonTree.getText() : null).charAt(1);
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
            return (char) 0;
        }
    }

    public final class_spec_return class_spec() throws RecognitionException {
        class_spec_return class_spec_returnVar = new class_spec_return();
        class_spec_returnVar.start = this.input.m3792LT(1);
        try {
            CommonTree commonTree = (CommonTree) match(this.input, 16, FOLLOW_CLASS_DESCRIPTOR_in_class_spec110);
            pushFollow(FOLLOW_access_list_in_class_spec112);
            int iAccess_list = access_list();
            this.state._fsp--;
            class_spec_returnVar.type = commonTree != null ? commonTree.getText() : null;
            class_spec_returnVar.accessFlags = iAccess_list;
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
        }
        return class_spec_returnVar;
    }

    public final void debug_directive() throws RecognitionException {
        char c;
        try {
            int iMo3787LA = this.input.mo3787LA(1);
            if (iMo3787LA == 115) {
                c = 3;
            } else if (iMo3787LA == 116) {
                c = 6;
            } else if (iMo3787LA == 123) {
                c = 1;
            } else if (iMo3787LA == 124) {
                c = 2;
            } else if (iMo3787LA == 136) {
                c = 5;
            } else if (iMo3787LA == 140) {
                c = 4;
            } else {
                if (iMo3787LA != 141) {
                    throw new NoViableAltException("", 27, 0, this.input);
                }
                c = 7;
            }
            switch (c) {
                case 1:
                    pushFollow(FOLLOW_line_in_debug_directive1660);
                    line();
                    this.state._fsp--;
                    return;
                case 2:
                    pushFollow(FOLLOW_local_in_debug_directive1666);
                    local();
                    this.state._fsp--;
                    return;
                case 3:
                    pushFollow(FOLLOW_end_local_in_debug_directive1672);
                    end_local();
                    this.state._fsp--;
                    return;
                case 4:
                    pushFollow(FOLLOW_restart_local_in_debug_directive1678);
                    restart_local();
                    this.state._fsp--;
                    return;
                case 5:
                    pushFollow(FOLLOW_prologue_in_debug_directive1684);
                    prologue();
                    this.state._fsp--;
                    return;
                case 6:
                    pushFollow(FOLLOW_epilogue_in_debug_directive1690);
                    epilogue();
                    this.state._fsp--;
                    return;
                case 7:
                    pushFollow(FOLLOW_source_in_debug_directive1696);
                    source();
                    this.state._fsp--;
                    return;
                default:
                    return;
            }
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
        }
    }

    public final double double_literal() throws RecognitionException {
        try {
            CommonTree commonTree = (CommonTree) match(this.input, 23, FOLLOW_DOUBLE_LITERAL_in_double_literal3863);
            return LiteralTools.parseDouble(commonTree != null ? commonTree.getText() : null);
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
            return 0.0d;
        }
    }

    public final void end_local() throws RecognitionException {
        try {
            match(this.input, C0299R.styleable.AppCompatTheme_switchStyle, FOLLOW_I_END_LOCAL_in_end_local1768);
            match(this.input, 2, null);
            CommonTree commonTree = (CommonTree) match(this.input, 204, FOLLOW_REGISTER_in_end_local1770);
            match(this.input, 3, null);
            this.method_stack.peek().methodBuilder.addEndLocal(parseRegister_short(commonTree != null ? commonTree.getText() : null));
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
        }
    }

    public final ImmutableFieldReference enum_literal() throws RecognitionException {
        try {
            match(this.input, C0299R.styleable.AppCompatTheme_ratingBarStyleIndicator, FOLLOW_I_ENCODED_ENUM_in_enum_literal4156);
            match(this.input, 2, null);
            pushFollow(FOLLOW_field_reference_in_enum_literal4158);
            field_reference_return field_reference_returnVarField_reference = field_reference();
            RecognizerSharedState recognizerSharedState = this.state;
            recognizerSharedState._fsp--;
            match(this.input, 3, null);
            if (field_reference_returnVarField_reference != null) {
                return field_reference_returnVarField_reference.fieldReference;
            }
            return null;
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
            return null;
        }
    }

    public final void epilogue() throws RecognitionException {
        try {
            match(this.input, C0299R.styleable.AppCompatTheme_listMenuViewStyle, FOLLOW_I_EPILOGUE_in_epilogue1823);
            this.method_stack.peek().methodBuilder.addEpilogue();
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
        }
    }

    public final BuilderField field() throws RecognitionException {
        Set<Annotation> set;
        try {
            match(this.input, C0299R.styleable.AppCompatTheme_tooltipFrameBackground, FOLLOW_I_FIELD_in_field480);
            match(this.input, 2, null);
            CommonTree commonTree = (CommonTree) match(this.input, 208, FOLLOW_SIMPLE_NAME_in_field482);
            pushFollow(FOLLOW_access_or_restriction_list_in_field484);
            access_or_restriction_list_return access_or_restriction_list_returnVarAccess_or_restriction_list = access_or_restriction_list();
            this.state._fsp--;
            match(this.input, 120, FOLLOW_I_FIELD_TYPE_in_field487);
            match(this.input, 2, null);
            pushFollow(FOLLOW_nonvoid_type_descriptor_in_field489);
            nonvoid_type_descriptor_return nonvoid_type_descriptor_returnVarNonvoid_type_descriptor = nonvoid_type_descriptor();
            this.state._fsp--;
            match(this.input, 3, null);
            pushFollow(FOLLOW_field_initial_value_in_field492);
            EncodedValue encodedValueField_initial_value = field_initial_value();
            this.state._fsp--;
            if ((this.input.mo3787LA(1) == 100 ? (char) 1 : (char) 2) != 1) {
                set = null;
            } else {
                pushFollow(FOLLOW_annotations_in_field494);
                Set<Annotation> setAnnotations = annotations();
                this.state._fsp--;
                set = setAnnotations;
            }
            match(this.input, 3, null);
            int i = access_or_restriction_list_returnVarAccess_or_restriction_list != null ? access_or_restriction_list_returnVarAccess_or_restriction_list.value : 0;
            Set<HiddenApiRestriction> set2 = access_or_restriction_list_returnVarAccess_or_restriction_list != null ? access_or_restriction_list_returnVarAccess_or_restriction_list.hiddenApiRestrictions : null;
            if (!AccessFlags.STATIC.isSet(i) && encodedValueField_initial_value != null) {
                throw new SemanticException(this.input, "Initial field values can only be specified for static fields.", new Object[0]);
            }
            return this.dexBuilder.internField(this.classType, commonTree != null ? commonTree.getText() : null, nonvoid_type_descriptor_returnVarNonvoid_type_descriptor != null ? nonvoid_type_descriptor_returnVarNonvoid_type_descriptor.type : null, i, encodedValueField_initial_value, set, set2);
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
            return null;
        }
    }

    public final EncodedValue field_initial_value() throws RecognitionException {
        char c;
        try {
            int iMo3787LA = this.input.mo3787LA(1);
            if (iMo3787LA == 119) {
                c = 1;
            } else {
                if (iMo3787LA != 3 && iMo3787LA != 100) {
                    throw new NoViableAltException("", 9, 0, this.input);
                }
                c = 2;
            }
            if (c != 1) {
                return null;
            }
            match(this.input, C0299R.styleable.AppCompatTheme_colorError, FOLLOW_I_FIELD_INITIAL_VALUE_in_field_initial_value515);
            match(this.input, 2, null);
            pushFollow(FOLLOW_literal_in_field_initial_value517);
            ImmutableEncodedValue immutableEncodedValueLiteral = literal();
            this.state._fsp--;
            match(this.input, 3, null);
            return immutableEncodedValueLiteral;
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
            return null;
        }
    }

    public final ImmutableFieldReference field_literal() throws RecognitionException {
        try {
            match(this.input, C0299R.styleable.AppCompatTheme_ratingBarStyleSmall, FOLLOW_I_ENCODED_FIELD_in_field_literal4110);
            match(this.input, 2, null);
            pushFollow(FOLLOW_field_reference_in_field_literal4112);
            field_reference_return field_reference_returnVarField_reference = field_reference();
            RecognizerSharedState recognizerSharedState = this.state;
            recognizerSharedState._fsp--;
            match(this.input, 3, null);
            if (field_reference_returnVarField_reference != null) {
                return field_reference_returnVarField_reference.fieldReference;
            }
            return null;
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
            return null;
        }
    }

    public final field_reference_return field_reference() throws RecognitionException {
        reference_type_descriptor_return reference_type_descriptor_returnVarReference_type_descriptor;
        field_reference_return field_reference_returnVar = new field_reference_return();
        field_reference_returnVar.start = this.input.m3792LT(1);
        try {
            int iMo3787LA = this.input.mo3787LA(1);
            if (((iMo3787LA == 8 || iMo3787LA == 16) ? (char) 1 : (char) 2) != 1) {
                reference_type_descriptor_returnVarReference_type_descriptor = null;
            } else {
                pushFollow(FOLLOW_reference_type_descriptor_in_field_reference1431);
                reference_type_descriptor_returnVarReference_type_descriptor = reference_type_descriptor();
                this.state._fsp--;
            }
            CommonTree commonTree = (CommonTree) match(this.input, 208, FOLLOW_SIMPLE_NAME_in_field_reference1434);
            pushFollow(FOLLOW_nonvoid_type_descriptor_in_field_reference1436);
            nonvoid_type_descriptor_return nonvoid_type_descriptor_returnVarNonvoid_type_descriptor = nonvoid_type_descriptor();
            this.state._fsp--;
            field_reference_returnVar.fieldReference = new ImmutableFieldReference((reference_type_descriptor_returnVarReference_type_descriptor != null ? reference_type_descriptor_returnVarReference_type_descriptor.type : null) == null ? this.classType : reference_type_descriptor_returnVarReference_type_descriptor != null ? reference_type_descriptor_returnVarReference_type_descriptor.type : null, commonTree != null ? commonTree.getText() : null, nonvoid_type_descriptor_returnVarNonvoid_type_descriptor != null ? nonvoid_type_descriptor_returnVarNonvoid_type_descriptor.type : null);
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
        }
        return field_reference_returnVar;
    }

    public final List<BuilderField> fields() throws RecognitionException {
        ArrayList arrayListNewArrayList = Lists.newArrayList();
        try {
            match(this.input, C0299R.styleable.AppCompatTheme_tooltipForegroundColor, FOLLOW_I_FIELDS_in_fields405);
            if (this.input.mo3787LA(1) == 2) {
                match(this.input, 2, null);
                while (true) {
                    if ((this.input.mo3787LA(1) == 117 ? (char) 1 : (char) 2) != 1) {
                        break;
                    }
                    pushFollow(FOLLOW_field_in_fields414);
                    BuilderField builderFieldField = field();
                    this.state._fsp--;
                    arrayListNewArrayList.add(builderFieldField);
                }
                match(this.input, 3, null);
            }
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
        }
        return arrayListNewArrayList;
    }

    public final int fixed_32bit_literal() throws RecognitionException {
        char c;
        boolean z;
        try {
            int iMo3787LA = this.input.mo3787LA(1);
            if (iMo3787LA == 11) {
                c = 7;
            } else if (iMo3787LA == 12) {
                c = 4;
            } else if (iMo3787LA == 15) {
                c = 6;
            } else if (iMo3787LA == 39) {
                c = 5;
            } else if (iMo3787LA == 95) {
                c = 1;
            } else if (iMo3787LA == 189) {
                c = 2;
            } else {
                if (iMo3787LA != 207) {
                    throw new NoViableAltException("", 13, 0, this.input);
                }
                c = 3;
            }
            switch (c) {
                case 1:
                    pushFollow(FOLLOW_integer_literal_in_fixed_32bit_literal835);
                    int iInteger_literal = integer_literal();
                    this.state._fsp--;
                    z = iInteger_literal;
                    break;
                case 2:
                    pushFollow(FOLLOW_long_literal_in_fixed_32bit_literal843);
                    long jLong_literal = long_literal();
                    this.state._fsp--;
                    LiteralTools.checkInt(jLong_literal);
                    return (int) jLong_literal;
                case 3:
                    pushFollow(FOLLOW_short_literal_in_fixed_32bit_literal851);
                    short sShort_literal = short_literal();
                    this.state._fsp--;
                    z = sShort_literal;
                    break;
                case 4:
                    pushFollow(FOLLOW_byte_literal_in_fixed_32bit_literal859);
                    byte bByte_literal = byte_literal();
                    this.state._fsp--;
                    z = bByte_literal;
                    break;
                case 5:
                    pushFollow(FOLLOW_float_literal_in_fixed_32bit_literal867);
                    float fFloat_literal = float_literal();
                    this.state._fsp--;
                    return Float.floatToRawIntBits(fFloat_literal);
                case 6:
                    pushFollow(FOLLOW_char_literal_in_fixed_32bit_literal875);
                    char cChar_literal = char_literal();
                    this.state._fsp--;
                    z = cChar_literal;
                    break;
                case 7:
                    pushFollow(FOLLOW_bool_literal_in_fixed_32bit_literal883);
                    boolean zBool_literal = bool_literal();
                    this.state._fsp--;
                    z = zBool_literal;
                    break;
                default:
                    return 0;
            }
            return z ? 1 : 0;
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
            return 0;
        }
    }

    public final long fixed_64bit_literal() throws RecognitionException {
        char c;
        int iInteger_literal;
        try {
            int iMo3787LA = this.input.mo3787LA(1);
            if (iMo3787LA == 11) {
                c = '\b';
            } else if (iMo3787LA == 12) {
                c = 4;
            } else if (iMo3787LA == 15) {
                c = 7;
            } else if (iMo3787LA == 23) {
                c = 6;
            } else if (iMo3787LA == 39) {
                c = 5;
            } else if (iMo3787LA == 95) {
                c = 1;
            } else if (iMo3787LA == 189) {
                c = 2;
            } else {
                if (iMo3787LA != 207) {
                    throw new NoViableAltException("", 12, 0, this.input);
                }
                c = 3;
            }
            switch (c) {
                case 1:
                    pushFollow(FOLLOW_integer_literal_in_fixed_64bit_literal762);
                    iInteger_literal = integer_literal();
                    this.state._fsp--;
                    break;
                case 2:
                    pushFollow(FOLLOW_long_literal_in_fixed_64bit_literal770);
                    long jLong_literal = long_literal();
                    this.state._fsp--;
                    return jLong_literal;
                case 3:
                    pushFollow(FOLLOW_short_literal_in_fixed_64bit_literal778);
                    iInteger_literal = short_literal();
                    this.state._fsp--;
                    break;
                case 4:
                    pushFollow(FOLLOW_byte_literal_in_fixed_64bit_literal786);
                    iInteger_literal = byte_literal();
                    this.state._fsp--;
                    break;
                case 5:
                    pushFollow(FOLLOW_float_literal_in_fixed_64bit_literal794);
                    float fFloat_literal = float_literal();
                    this.state._fsp--;
                    return Float.floatToRawIntBits(fFloat_literal);
                case 6:
                    pushFollow(FOLLOW_double_literal_in_fixed_64bit_literal802);
                    double dDouble_literal = double_literal();
                    this.state._fsp--;
                    return Double.doubleToRawLongBits(dDouble_literal);
                case 7:
                    pushFollow(FOLLOW_char_literal_in_fixed_64bit_literal810);
                    iInteger_literal = char_literal();
                    this.state._fsp--;
                    break;
                case '\b':
                    pushFollow(FOLLOW_bool_literal_in_fixed_64bit_literal818);
                    boolean zBool_literal = bool_literal();
                    this.state._fsp--;
                    return zBool_literal ? 1L : 0L;
                default:
                    return 0L;
            }
            return iInteger_literal;
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
            return 0L;
        }
    }

    public final Number fixed_64bit_literal_number() throws RecognitionException {
        char c;
        try {
            int i = 1;
            int iMo3787LA = this.input.mo3787LA(1);
            if (iMo3787LA == 11) {
                c = '\b';
            } else if (iMo3787LA == 12) {
                c = 4;
            } else if (iMo3787LA == 15) {
                c = 7;
            } else if (iMo3787LA == 23) {
                c = 6;
            } else if (iMo3787LA == 39) {
                c = 5;
            } else if (iMo3787LA == 95) {
                c = 1;
            } else if (iMo3787LA == 189) {
                c = 2;
            } else {
                if (iMo3787LA != 207) {
                    throw new NoViableAltException("", 11, 0, this.input);
                }
                c = 3;
            }
            switch (c) {
                case 1:
                    pushFollow(FOLLOW_integer_literal_in_fixed_64bit_literal_number691);
                    int iInteger_literal = integer_literal();
                    this.state._fsp--;
                    return Integer.valueOf(iInteger_literal);
                case 2:
                    pushFollow(FOLLOW_long_literal_in_fixed_64bit_literal_number699);
                    long jLong_literal = long_literal();
                    this.state._fsp--;
                    return Long.valueOf(jLong_literal);
                case 3:
                    pushFollow(FOLLOW_short_literal_in_fixed_64bit_literal_number707);
                    short sShort_literal = short_literal();
                    this.state._fsp--;
                    return Short.valueOf(sShort_literal);
                case 4:
                    pushFollow(FOLLOW_byte_literal_in_fixed_64bit_literal_number715);
                    byte bByte_literal = byte_literal();
                    this.state._fsp--;
                    return Byte.valueOf(bByte_literal);
                case 5:
                    pushFollow(FOLLOW_float_literal_in_fixed_64bit_literal_number723);
                    float fFloat_literal = float_literal();
                    this.state._fsp--;
                    return Integer.valueOf(Float.floatToRawIntBits(fFloat_literal));
                case 6:
                    pushFollow(FOLLOW_double_literal_in_fixed_64bit_literal_number731);
                    double dDouble_literal = double_literal();
                    this.state._fsp--;
                    return Long.valueOf(Double.doubleToRawLongBits(dDouble_literal));
                case 7:
                    pushFollow(FOLLOW_char_literal_in_fixed_64bit_literal_number739);
                    char cChar_literal = char_literal();
                    this.state._fsp--;
                    return Integer.valueOf(cChar_literal);
                case '\b':
                    pushFollow(FOLLOW_bool_literal_in_fixed_64bit_literal_number747);
                    boolean zBool_literal = bool_literal();
                    this.state._fsp--;
                    if (!zBool_literal) {
                        i = 0;
                    }
                    return Integer.valueOf(i);
                default:
                    return null;
            }
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
            return null;
        }
    }

    public final float float_literal() throws RecognitionException {
        try {
            CommonTree commonTree = (CommonTree) match(this.input, 39, FOLLOW_FLOAT_LITERAL_in_float_literal3848);
            return LiteralTools.parseFloat(commonTree != null ? commonTree.getText() : null);
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
            return 0.0f;
        }
    }

    @Override // org.antlr.runtime.BaseRecognizer
    public String getErrorHeader(RecognitionException recognitionException) {
        return getSourceName() + "[" + recognitionException.line + "," + recognitionException.charPositionInLine + "]";
    }

    @Override // org.antlr.runtime.tree.TreeParser, org.antlr.runtime.BaseRecognizer
    public String getErrorMessage(RecognitionException recognitionException, String[] strArr) {
        String message = recognitionException instanceof SemanticException ? recognitionException.getMessage() : super.getErrorMessage(recognitionException, strArr);
        this.errMessages += getErrorHeader(recognitionException) + " " + message + "\n";
        return message;
    }

    public String getErrorMessages() {
        return this.errMessages;
    }

    @Override // org.antlr.runtime.BaseRecognizer
    public String[] getTokenNames() {
        return tokenNames;
    }

    public final header_return header() throws RecognitionException {
        String strSuper_spec;
        header_return header_returnVar = new header_return();
        header_returnVar.start = this.input.m3792LT(1);
        try {
            pushFollow(FOLLOW_class_spec_in_header85);
            class_spec_return class_spec_returnVarClass_spec = class_spec();
            this.state._fsp--;
            if ((this.input.mo3787LA(1) == 184 ? (char) 1 : (char) 2) != 1) {
                strSuper_spec = null;
            } else {
                pushFollow(FOLLOW_super_spec_in_header87);
                strSuper_spec = super_spec();
                this.state._fsp--;
            }
            pushFollow(FOLLOW_implements_list_in_header90);
            List<String> listImplements_list = implements_list();
            this.state._fsp--;
            pushFollow(FOLLOW_source_spec_in_header92);
            String strSource_spec = source_spec();
            this.state._fsp--;
            String str = class_spec_returnVarClass_spec != null ? class_spec_returnVarClass_spec.type : null;
            this.classType = str;
            header_returnVar.classType = str;
            header_returnVar.accessFlags = class_spec_returnVarClass_spec != null ? class_spec_returnVarClass_spec.accessFlags : 0;
            header_returnVar.superType = strSuper_spec;
            header_returnVar.implementsList = listImplements_list;
            header_returnVar.sourceSpec = strSource_spec;
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
        }
        return header_returnVar;
    }

    public final List<String> implements_list() throws RecognitionException {
        try {
            ArrayList arrayListNewArrayList = Lists.newArrayList();
            while (true) {
                if ((this.input.mo3787LA(1) == 121 ? (char) 1 : (char) 2) != 1) {
                    break;
                }
                pushFollow(FOLLOW_implements_spec_in_implements_list184);
                String strImplements_spec = implements_spec();
                this.state._fsp--;
                arrayListNewArrayList.add(strImplements_spec);
            }
            if (arrayListNewArrayList.size() > 0) {
                return arrayListNewArrayList;
            }
            return null;
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
            return null;
        }
    }

    public final String implements_spec() throws RecognitionException {
        try {
            match(this.input, 121, FOLLOW_I_IMPLEMENTS_in_implements_spec152);
            match(this.input, 2, null);
            CommonTree commonTree = (CommonTree) match(this.input, 16, FOLLOW_CLASS_DESCRIPTOR_in_implements_spec154);
            match(this.input, 3, null);
            if (commonTree != null) {
                return commonTree.getText();
            }
            return null;
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
            return null;
        }
    }

    public final void insn_array_data_directive() throws RecognitionException {
        try {
            match(this.input, 143, FOLLOW_I_STATEMENT_ARRAY_DATA_in_insn_array_data_directive3463);
            match(this.input, 2, null);
            match(this.input, C0299R.styleable.AppCompatTheme_autoCompleteTextViewStyle, FOLLOW_I_ARRAY_ELEMENT_SIZE_in_insn_array_data_directive3466);
            match(this.input, 2, null);
            pushFollow(FOLLOW_short_integral_literal_in_insn_array_data_directive3468);
            short sShort_integral_literal = short_integral_literal();
            RecognizerSharedState recognizerSharedState = this.state;
            recognizerSharedState._fsp--;
            match(this.input, 3, null);
            pushFollow(FOLLOW_array_elements_in_insn_array_data_directive3471);
            List<Number> listArray_elements = array_elements();
            RecognizerSharedState recognizerSharedState2 = this.state;
            recognizerSharedState2._fsp--;
            match(this.input, 3, null);
            this.method_stack.peek().methodBuilder.addInstruction(new BuilderArrayPayload(sShort_integral_literal, listArray_elements));
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
        }
    }

    public final void insn_format10t() throws RecognitionException {
        try {
            match(this.input, 144, FOLLOW_I_STATEMENT_FORMAT10t_in_insn_format10t2314);
            match(this.input, 2, null);
            CommonTree commonTree = (CommonTree) match(this.input, 44, FOLLOW_INSTRUCTION_FORMAT10t_in_insn_format10t2316);
            pushFollow(FOLLOW_label_ref_in_insn_format10t2318);
            Label labelLabel_ref = label_ref();
            RecognizerSharedState recognizerSharedState = this.state;
            recognizerSharedState._fsp--;
            match(this.input, 3, null);
            this.method_stack.peek().methodBuilder.addInstruction(new BuilderInstruction10t(this.opcodes.getOpcodeByName(commonTree != null ? commonTree.getText() : null), labelLabel_ref));
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
        }
    }

    public final void insn_format10x() throws RecognitionException {
        try {
            match(this.input, 145, FOLLOW_I_STATEMENT_FORMAT10x_in_insn_format10x2341);
            match(this.input, 2, null);
            CommonTree commonTree = (CommonTree) match(this.input, 45, FOLLOW_INSTRUCTION_FORMAT10x_in_insn_format10x2343);
            match(this.input, 3, null);
            this.method_stack.peek().methodBuilder.addInstruction(new BuilderInstruction10x(this.opcodes.getOpcodeByName(commonTree != null ? commonTree.getText() : null)));
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
        }
    }

    public final void insn_format11n() throws RecognitionException {
        try {
            match(this.input, 146, FOLLOW_I_STATEMENT_FORMAT11n_in_insn_format11n2366);
            match(this.input, 2, null);
            CommonTree commonTree = (CommonTree) match(this.input, 47, FOLLOW_INSTRUCTION_FORMAT11n_in_insn_format11n2368);
            CommonTree commonTree2 = (CommonTree) match(this.input, 204, FOLLOW_REGISTER_in_insn_format11n2370);
            pushFollow(FOLLOW_short_integral_literal_in_insn_format11n2372);
            short sShort_integral_literal = short_integral_literal();
            RecognizerSharedState recognizerSharedState = this.state;
            recognizerSharedState._fsp--;
            match(this.input, 3, null);
            Opcode opcodeByName = this.opcodes.getOpcodeByName(commonTree != null ? commonTree.getText() : null);
            byte register_nibble = parseRegister_nibble(commonTree2 != null ? commonTree2.getText() : null);
            LiteralTools.checkNibble(sShort_integral_literal);
            this.method_stack.peek().methodBuilder.addInstruction(new BuilderInstruction11n(opcodeByName, register_nibble, sShort_integral_literal));
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
        }
    }

    public final void insn_format11x() throws RecognitionException {
        try {
            match(this.input, 147, FOLLOW_I_STATEMENT_FORMAT11x_in_insn_format11x2395);
            match(this.input, 2, null);
            CommonTree commonTree = (CommonTree) match(this.input, 48, FOLLOW_INSTRUCTION_FORMAT11x_in_insn_format11x2397);
            CommonTree commonTree2 = (CommonTree) match(this.input, 204, FOLLOW_REGISTER_in_insn_format11x2399);
            match(this.input, 3, null);
            this.method_stack.peek().methodBuilder.addInstruction(new BuilderInstruction11x(this.opcodes.getOpcodeByName(commonTree != null ? commonTree.getText() : null), parseRegister_byte(commonTree2 != null ? commonTree2.getText() : null)));
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
        }
    }

    public final void insn_format12x() throws RecognitionException {
        try {
            match(this.input, 148, FOLLOW_I_STATEMENT_FORMAT12x_in_insn_format12x2422);
            match(this.input, 2, null);
            CommonTree commonTree = (CommonTree) match(this.input, 49, FOLLOW_INSTRUCTION_FORMAT12x_in_insn_format12x2424);
            CommonTree commonTree2 = (CommonTree) match(this.input, 204, FOLLOW_REGISTER_in_insn_format12x2428);
            CommonTree commonTree3 = (CommonTree) match(this.input, 204, FOLLOW_REGISTER_in_insn_format12x2432);
            match(this.input, 3, null);
            this.method_stack.peek().methodBuilder.addInstruction(new BuilderInstruction12x(this.opcodes.getOpcodeByName(commonTree != null ? commonTree.getText() : null), parseRegister_nibble(commonTree2 != null ? commonTree2.getText() : null), parseRegister_nibble(commonTree3 != null ? commonTree3.getText() : null)));
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
        }
    }

    public final void insn_format20bc() throws RecognitionException {
        try {
            match(this.input, 149, FOLLOW_I_STATEMENT_FORMAT20bc_in_insn_format20bc2455);
            match(this.input, 2, null);
            CommonTree commonTree = (CommonTree) match(this.input, 51, FOLLOW_INSTRUCTION_FORMAT20bc_in_insn_format20bc2457);
            pushFollow(FOLLOW_verification_error_type_in_insn_format20bc2459);
            int iVerification_error_type = verification_error_type();
            RecognizerSharedState recognizerSharedState = this.state;
            recognizerSharedState._fsp--;
            pushFollow(FOLLOW_verification_error_reference_in_insn_format20bc2461);
            ImmutableReference immutableReferenceVerification_error_reference = verification_error_reference();
            RecognizerSharedState recognizerSharedState2 = this.state;
            recognizerSharedState2._fsp--;
            match(this.input, 3, null);
            this.method_stack.peek().methodBuilder.addInstruction(new BuilderInstruction20bc(this.opcodes.getOpcodeByName(commonTree != null ? commonTree.getText() : null), iVerification_error_type, this.dexBuilder.internReference(immutableReferenceVerification_error_reference)));
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
        }
    }

    public final void insn_format20t() throws RecognitionException {
        try {
            match(this.input, 150, FOLLOW_I_STATEMENT_FORMAT20t_in_insn_format20t2484);
            match(this.input, 2, null);
            CommonTree commonTree = (CommonTree) match(this.input, 52, FOLLOW_INSTRUCTION_FORMAT20t_in_insn_format20t2486);
            pushFollow(FOLLOW_label_ref_in_insn_format20t2488);
            Label labelLabel_ref = label_ref();
            RecognizerSharedState recognizerSharedState = this.state;
            recognizerSharedState._fsp--;
            match(this.input, 3, null);
            this.method_stack.peek().methodBuilder.addInstruction(new BuilderInstruction20t(this.opcodes.getOpcodeByName(commonTree != null ? commonTree.getText() : null), labelLabel_ref));
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
        }
    }

    public final void insn_format21c_field() throws RecognitionException {
        try {
            match(this.input, 151, FOLLOW_I_STATEMENT_FORMAT21c_FIELD_in_insn_format21c_field2511);
            match(this.input, 2, null);
            CommonTree commonTree = (CommonTree) this.input.m3792LT(1);
            if (this.input.mo3787LA(1) < 53 || this.input.mo3787LA(1) > 54) {
                throw new MismatchedSetException(null, this.input);
            }
            this.input.consume();
            this.state.errorRecovery = false;
            CommonTree commonTree2 = (CommonTree) match(this.input, 204, FOLLOW_REGISTER_in_insn_format21c_field2523);
            pushFollow(FOLLOW_field_reference_in_insn_format21c_field2525);
            field_reference_return field_reference_returnVarField_reference = field_reference();
            this.state._fsp--;
            match(this.input, 3, null);
            this.method_stack.peek().methodBuilder.addInstruction(new BuilderInstruction21c(this.opcodes.getOpcodeByName(commonTree != null ? commonTree.getText() : null), parseRegister_byte(commonTree2 != null ? commonTree2.getText() : null), this.dexBuilder.internFieldReference(field_reference_returnVarField_reference != null ? field_reference_returnVarField_reference.fieldReference : null)));
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
        }
    }

    public final void insn_format21c_method_handle() throws RecognitionException {
        try {
            match(this.input, 152, f4806x73619f17);
            match(this.input, 2, null);
            CommonTree commonTree = (CommonTree) match(this.input, 55, f4797x8b66dd46);
            CommonTree commonTree2 = (CommonTree) match(this.input, 204, FOLLOW_REGISTER_in_insn_format21c_method_handle2556);
            pushFollow(f4814xd17b2dfa);
            ImmutableMethodHandleReference immutableMethodHandleReferenceMethod_handle_reference = method_handle_reference();
            RecognizerSharedState recognizerSharedState = this.state;
            recognizerSharedState._fsp--;
            match(this.input, 3, null);
            this.method_stack.peek().methodBuilder.addInstruction(new BuilderInstruction21c(this.opcodes.getOpcodeByName(commonTree != null ? commonTree.getText() : null), parseRegister_byte(commonTree2 != null ? commonTree2.getText() : null), this.dexBuilder.internMethodHandle(immutableMethodHandleReferenceMethod_handle_reference)));
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
        }
    }

    public final void insn_format21c_method_type() throws RecognitionException {
        try {
            match(this.input, 153, f4807x74980830);
            match(this.input, 2, null);
            CommonTree commonTree = (CommonTree) match(this.input, 56, f4798xcbb198ca);
            CommonTree commonTree2 = (CommonTree) match(this.input, 204, FOLLOW_REGISTER_in_insn_format21c_method_type2589);
            pushFollow(FOLLOW_method_prototype_in_insn_format21c_method_type2591);
            ImmutableMethodProtoReference immutableMethodProtoReferenceMethod_prototype = method_prototype();
            RecognizerSharedState recognizerSharedState = this.state;
            recognizerSharedState._fsp--;
            match(this.input, 3, null);
            this.method_stack.peek().methodBuilder.addInstruction(new BuilderInstruction21c(this.opcodes.getOpcodeByName(commonTree != null ? commonTree.getText() : null), parseRegister_byte(commonTree2 != null ? commonTree2.getText() : null), this.dexBuilder.internMethodProtoReference(immutableMethodProtoReferenceMethod_prototype)));
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
        }
    }

    public final void insn_format21c_string() throws RecognitionException {
        try {
            match(this.input, 154, FOLLOW_I_STATEMENT_FORMAT21c_STRING_in_insn_format21c_string2614);
            match(this.input, 2, null);
            CommonTree commonTree = (CommonTree) match(this.input, 57, FOLLOW_INSTRUCTION_FORMAT21c_STRING_in_insn_format21c_string2616);
            CommonTree commonTree2 = (CommonTree) match(this.input, 204, FOLLOW_REGISTER_in_insn_format21c_string2618);
            pushFollow(FOLLOW_string_literal_in_insn_format21c_string2620);
            String strString_literal = string_literal();
            RecognizerSharedState recognizerSharedState = this.state;
            recognizerSharedState._fsp--;
            match(this.input, 3, null);
            this.method_stack.peek().methodBuilder.addInstruction(new BuilderInstruction21c(this.opcodes.getOpcodeByName(commonTree != null ? commonTree.getText() : null), parseRegister_byte(commonTree2 != null ? commonTree2.getText() : null), this.dexBuilder.internStringReference(strString_literal)));
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
        }
    }

    public final void insn_format21c_type() throws RecognitionException {
        try {
            match(this.input, 155, FOLLOW_I_STATEMENT_FORMAT21c_TYPE_in_insn_format21c_type2643);
            match(this.input, 2, null);
            CommonTree commonTree = (CommonTree) match(this.input, 58, FOLLOW_INSTRUCTION_FORMAT21c_TYPE_in_insn_format21c_type2645);
            CommonTree commonTree2 = (CommonTree) match(this.input, 204, FOLLOW_REGISTER_in_insn_format21c_type2647);
            pushFollow(FOLLOW_nonvoid_type_descriptor_in_insn_format21c_type2649);
            nonvoid_type_descriptor_return nonvoid_type_descriptor_returnVarNonvoid_type_descriptor = nonvoid_type_descriptor();
            RecognizerSharedState recognizerSharedState = this.state;
            recognizerSharedState._fsp--;
            match(this.input, 3, null);
            this.method_stack.peek().methodBuilder.addInstruction(new BuilderInstruction21c(this.opcodes.getOpcodeByName(commonTree != null ? commonTree.getText() : null), parseRegister_byte(commonTree2 != null ? commonTree2.getText() : null), this.dexBuilder.internTypeReference(nonvoid_type_descriptor_returnVarNonvoid_type_descriptor != null ? nonvoid_type_descriptor_returnVarNonvoid_type_descriptor.type : null)));
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
        }
    }

    public final void insn_format21ih() throws RecognitionException {
        try {
            match(this.input, 156, FOLLOW_I_STATEMENT_FORMAT21ih_in_insn_format21ih2672);
            match(this.input, 2, null);
            CommonTree commonTree = (CommonTree) match(this.input, 59, FOLLOW_INSTRUCTION_FORMAT21ih_in_insn_format21ih2674);
            CommonTree commonTree2 = (CommonTree) match(this.input, 204, FOLLOW_REGISTER_in_insn_format21ih2676);
            pushFollow(FOLLOW_fixed_32bit_literal_in_insn_format21ih2678);
            int iFixed_32bit_literal = fixed_32bit_literal();
            RecognizerSharedState recognizerSharedState = this.state;
            recognizerSharedState._fsp--;
            match(this.input, 3, null);
            this.method_stack.peek().methodBuilder.addInstruction(new BuilderInstruction21ih(this.opcodes.getOpcodeByName(commonTree != null ? commonTree.getText() : null), parseRegister_byte(commonTree2 != null ? commonTree2.getText() : null), iFixed_32bit_literal));
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
        }
    }

    public final void insn_format21lh() throws RecognitionException {
        try {
            match(this.input, 157, FOLLOW_I_STATEMENT_FORMAT21lh_in_insn_format21lh2701);
            match(this.input, 2, null);
            CommonTree commonTree = (CommonTree) match(this.input, 60, FOLLOW_INSTRUCTION_FORMAT21lh_in_insn_format21lh2703);
            CommonTree commonTree2 = (CommonTree) match(this.input, 204, FOLLOW_REGISTER_in_insn_format21lh2705);
            pushFollow(FOLLOW_fixed_64bit_literal_in_insn_format21lh2707);
            long jFixed_64bit_literal = fixed_64bit_literal();
            RecognizerSharedState recognizerSharedState = this.state;
            recognizerSharedState._fsp--;
            match(this.input, 3, null);
            this.method_stack.peek().methodBuilder.addInstruction(new BuilderInstruction21lh(this.opcodes.getOpcodeByName(commonTree != null ? commonTree.getText() : null), parseRegister_byte(commonTree2 != null ? commonTree2.getText() : null), jFixed_64bit_literal));
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
        }
    }

    public final void insn_format21s() throws RecognitionException {
        try {
            match(this.input, 158, FOLLOW_I_STATEMENT_FORMAT21s_in_insn_format21s2730);
            match(this.input, 2, null);
            CommonTree commonTree = (CommonTree) match(this.input, 61, FOLLOW_INSTRUCTION_FORMAT21s_in_insn_format21s2732);
            CommonTree commonTree2 = (CommonTree) match(this.input, 204, FOLLOW_REGISTER_in_insn_format21s2734);
            pushFollow(FOLLOW_short_integral_literal_in_insn_format21s2736);
            short sShort_integral_literal = short_integral_literal();
            RecognizerSharedState recognizerSharedState = this.state;
            recognizerSharedState._fsp--;
            match(this.input, 3, null);
            this.method_stack.peek().methodBuilder.addInstruction(new BuilderInstruction21s(this.opcodes.getOpcodeByName(commonTree != null ? commonTree.getText() : null), parseRegister_byte(commonTree2 != null ? commonTree2.getText() : null), sShort_integral_literal));
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
        }
    }

    public final void insn_format21t() throws RecognitionException {
        try {
            match(this.input, 159, FOLLOW_I_STATEMENT_FORMAT21t_in_insn_format21t2759);
            match(this.input, 2, null);
            CommonTree commonTree = (CommonTree) match(this.input, 62, FOLLOW_INSTRUCTION_FORMAT21t_in_insn_format21t2761);
            CommonTree commonTree2 = (CommonTree) match(this.input, 204, FOLLOW_REGISTER_in_insn_format21t2763);
            pushFollow(FOLLOW_label_ref_in_insn_format21t2765);
            Label labelLabel_ref = label_ref();
            RecognizerSharedState recognizerSharedState = this.state;
            recognizerSharedState._fsp--;
            match(this.input, 3, null);
            this.method_stack.peek().methodBuilder.addInstruction(new BuilderInstruction21t(this.opcodes.getOpcodeByName(commonTree != null ? commonTree.getText() : null), parseRegister_byte(commonTree2 != null ? commonTree2.getText() : null), labelLabel_ref));
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
        }
    }

    public final void insn_format22b() throws RecognitionException {
        try {
            match(this.input, 160, FOLLOW_I_STATEMENT_FORMAT22b_in_insn_format22b2788);
            match(this.input, 2, null);
            CommonTree commonTree = (CommonTree) match(this.input, 63, FOLLOW_INSTRUCTION_FORMAT22b_in_insn_format22b2790);
            CommonTree commonTree2 = (CommonTree) match(this.input, 204, FOLLOW_REGISTER_in_insn_format22b2794);
            CommonTree commonTree3 = (CommonTree) match(this.input, 204, FOLLOW_REGISTER_in_insn_format22b2798);
            pushFollow(FOLLOW_short_integral_literal_in_insn_format22b2800);
            short sShort_integral_literal = short_integral_literal();
            RecognizerSharedState recognizerSharedState = this.state;
            recognizerSharedState._fsp--;
            match(this.input, 3, null);
            Opcode opcodeByName = this.opcodes.getOpcodeByName(commonTree != null ? commonTree.getText() : null);
            short register_byte = parseRegister_byte(commonTree2 != null ? commonTree2.getText() : null);
            short register_byte2 = parseRegister_byte(commonTree3 != null ? commonTree3.getText() : null);
            LiteralTools.checkByte(sShort_integral_literal);
            this.method_stack.peek().methodBuilder.addInstruction(new BuilderInstruction22b(opcodeByName, register_byte, register_byte2, sShort_integral_literal));
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
        }
    }

    public final void insn_format22c_field() throws RecognitionException {
        try {
            match(this.input, 161, FOLLOW_I_STATEMENT_FORMAT22c_FIELD_in_insn_format22c_field2823);
            match(this.input, 2, null);
            CommonTree commonTree = (CommonTree) this.input.m3792LT(1);
            if (this.input.mo3787LA(1) < 64 || this.input.mo3787LA(1) > 65) {
                throw new MismatchedSetException(null, this.input);
            }
            this.input.consume();
            this.state.errorRecovery = false;
            CommonTree commonTree2 = (CommonTree) match(this.input, 204, FOLLOW_REGISTER_in_insn_format22c_field2837);
            CommonTree commonTree3 = (CommonTree) match(this.input, 204, FOLLOW_REGISTER_in_insn_format22c_field2841);
            pushFollow(FOLLOW_field_reference_in_insn_format22c_field2843);
            field_reference_return field_reference_returnVarField_reference = field_reference();
            this.state._fsp--;
            match(this.input, 3, null);
            this.method_stack.peek().methodBuilder.addInstruction(new BuilderInstruction22c(this.opcodes.getOpcodeByName(commonTree != null ? commonTree.getText() : null), parseRegister_nibble(commonTree2 != null ? commonTree2.getText() : null), parseRegister_nibble(commonTree3 != null ? commonTree3.getText() : null), this.dexBuilder.internFieldReference(field_reference_returnVarField_reference != null ? field_reference_returnVarField_reference.fieldReference : null)));
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
        }
    }

    public final void insn_format22c_type() throws RecognitionException {
        try {
            match(this.input, 162, FOLLOW_I_STATEMENT_FORMAT22c_TYPE_in_insn_format22c_type2866);
            match(this.input, 2, null);
            CommonTree commonTree = (CommonTree) match(this.input, 66, FOLLOW_INSTRUCTION_FORMAT22c_TYPE_in_insn_format22c_type2868);
            CommonTree commonTree2 = (CommonTree) match(this.input, 204, FOLLOW_REGISTER_in_insn_format22c_type2872);
            CommonTree commonTree3 = (CommonTree) match(this.input, 204, FOLLOW_REGISTER_in_insn_format22c_type2876);
            pushFollow(FOLLOW_nonvoid_type_descriptor_in_insn_format22c_type2878);
            nonvoid_type_descriptor_return nonvoid_type_descriptor_returnVarNonvoid_type_descriptor = nonvoid_type_descriptor();
            RecognizerSharedState recognizerSharedState = this.state;
            recognizerSharedState._fsp--;
            match(this.input, 3, null);
            this.method_stack.peek().methodBuilder.addInstruction(new BuilderInstruction22c(this.opcodes.getOpcodeByName(commonTree != null ? commonTree.getText() : null), parseRegister_nibble(commonTree2 != null ? commonTree2.getText() : null), parseRegister_nibble(commonTree3 != null ? commonTree3.getText() : null), this.dexBuilder.internTypeReference(nonvoid_type_descriptor_returnVarNonvoid_type_descriptor != null ? nonvoid_type_descriptor_returnVarNonvoid_type_descriptor.type : null)));
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
        }
    }

    public final void insn_format22s() throws RecognitionException {
        try {
            match(this.input, 163, FOLLOW_I_STATEMENT_FORMAT22s_in_insn_format22s2901);
            match(this.input, 2, null);
            CommonTree commonTree = (CommonTree) match(this.input, 68, FOLLOW_INSTRUCTION_FORMAT22s_in_insn_format22s2903);
            CommonTree commonTree2 = (CommonTree) match(this.input, 204, FOLLOW_REGISTER_in_insn_format22s2907);
            CommonTree commonTree3 = (CommonTree) match(this.input, 204, FOLLOW_REGISTER_in_insn_format22s2911);
            pushFollow(FOLLOW_short_integral_literal_in_insn_format22s2913);
            short sShort_integral_literal = short_integral_literal();
            RecognizerSharedState recognizerSharedState = this.state;
            recognizerSharedState._fsp--;
            match(this.input, 3, null);
            this.method_stack.peek().methodBuilder.addInstruction(new BuilderInstruction22s(this.opcodes.getOpcodeByName(commonTree != null ? commonTree.getText() : null), parseRegister_nibble(commonTree2 != null ? commonTree2.getText() : null), parseRegister_nibble(commonTree3 != null ? commonTree3.getText() : null), sShort_integral_literal));
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
        }
    }

    public final void insn_format22t() throws RecognitionException {
        try {
            match(this.input, 164, FOLLOW_I_STATEMENT_FORMAT22t_in_insn_format22t2936);
            match(this.input, 2, null);
            CommonTree commonTree = (CommonTree) match(this.input, 70, FOLLOW_INSTRUCTION_FORMAT22t_in_insn_format22t2938);
            CommonTree commonTree2 = (CommonTree) match(this.input, 204, FOLLOW_REGISTER_in_insn_format22t2942);
            CommonTree commonTree3 = (CommonTree) match(this.input, 204, FOLLOW_REGISTER_in_insn_format22t2946);
            pushFollow(FOLLOW_label_ref_in_insn_format22t2948);
            Label labelLabel_ref = label_ref();
            RecognizerSharedState recognizerSharedState = this.state;
            recognizerSharedState._fsp--;
            match(this.input, 3, null);
            this.method_stack.peek().methodBuilder.addInstruction(new BuilderInstruction22t(this.opcodes.getOpcodeByName(commonTree != null ? commonTree.getText() : null), parseRegister_nibble(commonTree2 != null ? commonTree2.getText() : null), parseRegister_nibble(commonTree3 != null ? commonTree3.getText() : null), labelLabel_ref));
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
        }
    }

    public final void insn_format22x() throws RecognitionException {
        try {
            match(this.input, 165, FOLLOW_I_STATEMENT_FORMAT22x_in_insn_format22x2971);
            match(this.input, 2, null);
            CommonTree commonTree = (CommonTree) match(this.input, 71, FOLLOW_INSTRUCTION_FORMAT22x_in_insn_format22x2973);
            CommonTree commonTree2 = (CommonTree) match(this.input, 204, FOLLOW_REGISTER_in_insn_format22x2977);
            CommonTree commonTree3 = (CommonTree) match(this.input, 204, FOLLOW_REGISTER_in_insn_format22x2981);
            match(this.input, 3, null);
            this.method_stack.peek().methodBuilder.addInstruction(new BuilderInstruction22x(this.opcodes.getOpcodeByName(commonTree != null ? commonTree.getText() : null), parseRegister_byte(commonTree2 != null ? commonTree2.getText() : null), parseRegister_short(commonTree3 != null ? commonTree3.getText() : null)));
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
        }
    }

    public final void insn_format23x() throws RecognitionException {
        try {
            match(this.input, 166, FOLLOW_I_STATEMENT_FORMAT23x_in_insn_format23x3004);
            match(this.input, 2, null);
            CommonTree commonTree = (CommonTree) match(this.input, 72, FOLLOW_INSTRUCTION_FORMAT23x_in_insn_format23x3006);
            CommonTree commonTree2 = (CommonTree) match(this.input, 204, FOLLOW_REGISTER_in_insn_format23x3010);
            CommonTree commonTree3 = (CommonTree) match(this.input, 204, FOLLOW_REGISTER_in_insn_format23x3014);
            CommonTree commonTree4 = (CommonTree) match(this.input, 204, FOLLOW_REGISTER_in_insn_format23x3018);
            match(this.input, 3, null);
            this.method_stack.peek().methodBuilder.addInstruction(new BuilderInstruction23x(this.opcodes.getOpcodeByName(commonTree != null ? commonTree.getText() : null), parseRegister_byte(commonTree2 != null ? commonTree2.getText() : null), parseRegister_byte(commonTree3 != null ? commonTree3.getText() : null), parseRegister_byte(commonTree4 != null ? commonTree4.getText() : null)));
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
        }
    }

    public final void insn_format30t() throws RecognitionException {
        try {
            match(this.input, 167, FOLLOW_I_STATEMENT_FORMAT30t_in_insn_format30t3041);
            match(this.input, 2, null);
            CommonTree commonTree = (CommonTree) match(this.input, 73, FOLLOW_INSTRUCTION_FORMAT30t_in_insn_format30t3043);
            pushFollow(FOLLOW_label_ref_in_insn_format30t3045);
            Label labelLabel_ref = label_ref();
            RecognizerSharedState recognizerSharedState = this.state;
            recognizerSharedState._fsp--;
            match(this.input, 3, null);
            this.method_stack.peek().methodBuilder.addInstruction(new BuilderInstruction30t(this.opcodes.getOpcodeByName(commonTree != null ? commonTree.getText() : null), labelLabel_ref));
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
        }
    }

    public final void insn_format31c() throws RecognitionException {
        try {
            match(this.input, 168, FOLLOW_I_STATEMENT_FORMAT31c_in_insn_format31c3068);
            match(this.input, 2, null);
            CommonTree commonTree = (CommonTree) match(this.input, 74, FOLLOW_INSTRUCTION_FORMAT31c_in_insn_format31c3070);
            CommonTree commonTree2 = (CommonTree) match(this.input, 204, FOLLOW_REGISTER_in_insn_format31c3072);
            pushFollow(FOLLOW_string_literal_in_insn_format31c3074);
            String strString_literal = string_literal();
            RecognizerSharedState recognizerSharedState = this.state;
            recognizerSharedState._fsp--;
            match(this.input, 3, null);
            this.method_stack.peek().methodBuilder.addInstruction(new BuilderInstruction31c(this.opcodes.getOpcodeByName(commonTree != null ? commonTree.getText() : null), parseRegister_byte(commonTree2 != null ? commonTree2.getText() : null), this.dexBuilder.internStringReference(strString_literal)));
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
        }
    }

    public final void insn_format31i() throws RecognitionException {
        try {
            match(this.input, 169, FOLLOW_I_STATEMENT_FORMAT31i_in_insn_format31i3097);
            match(this.input, 2, null);
            CommonTree commonTree = (CommonTree) match(this.input, 75, FOLLOW_INSTRUCTION_FORMAT31i_in_insn_format31i3099);
            CommonTree commonTree2 = (CommonTree) match(this.input, 204, FOLLOW_REGISTER_in_insn_format31i3101);
            pushFollow(FOLLOW_fixed_32bit_literal_in_insn_format31i3103);
            int iFixed_32bit_literal = fixed_32bit_literal();
            RecognizerSharedState recognizerSharedState = this.state;
            recognizerSharedState._fsp--;
            match(this.input, 3, null);
            this.method_stack.peek().methodBuilder.addInstruction(new BuilderInstruction31i(this.opcodes.getOpcodeByName(commonTree != null ? commonTree.getText() : null), parseRegister_byte(commonTree2 != null ? commonTree2.getText() : null), iFixed_32bit_literal));
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
        }
    }

    public final void insn_format31t() throws RecognitionException {
        try {
            match(this.input, 170, FOLLOW_I_STATEMENT_FORMAT31t_in_insn_format31t3126);
            match(this.input, 2, null);
            CommonTree commonTree = (CommonTree) match(this.input, 77, FOLLOW_INSTRUCTION_FORMAT31t_in_insn_format31t3128);
            CommonTree commonTree2 = (CommonTree) match(this.input, 204, FOLLOW_REGISTER_in_insn_format31t3130);
            pushFollow(FOLLOW_label_ref_in_insn_format31t3132);
            Label labelLabel_ref = label_ref();
            RecognizerSharedState recognizerSharedState = this.state;
            recognizerSharedState._fsp--;
            match(this.input, 3, null);
            this.method_stack.peek().methodBuilder.addInstruction(new BuilderInstruction31t(this.opcodes.getOpcodeByName(commonTree != null ? commonTree.getText() : null), parseRegister_byte(commonTree2 != null ? commonTree2.getText() : null), labelLabel_ref));
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
        }
    }

    public final void insn_format32x() throws RecognitionException {
        try {
            match(this.input, 171, FOLLOW_I_STATEMENT_FORMAT32x_in_insn_format32x3155);
            match(this.input, 2, null);
            CommonTree commonTree = (CommonTree) match(this.input, 78, FOLLOW_INSTRUCTION_FORMAT32x_in_insn_format32x3157);
            CommonTree commonTree2 = (CommonTree) match(this.input, 204, FOLLOW_REGISTER_in_insn_format32x3161);
            CommonTree commonTree3 = (CommonTree) match(this.input, 204, FOLLOW_REGISTER_in_insn_format32x3165);
            match(this.input, 3, null);
            this.method_stack.peek().methodBuilder.addInstruction(new BuilderInstruction32x(this.opcodes.getOpcodeByName(commonTree != null ? commonTree.getText() : null), parseRegister_short(commonTree2 != null ? commonTree2.getText() : null), parseRegister_short(commonTree3 != null ? commonTree3.getText() : null)));
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
        }
    }

    public final void insn_format35c_call_site() throws RecognitionException {
        try {
            match(this.input, 172, f4808x5b268606);
            match(this.input, 2, null);
            CommonTree commonTree = (CommonTree) match(this.input, 79, f4799x5961a91d);
            pushFollow(FOLLOW_register_list_in_insn_format35c_call_site3197);
            register_list_return register_list_returnVarRegister_list = register_list();
            this.state._fsp--;
            pushFollow(FOLLOW_call_site_reference_in_insn_format35c_call_site3199);
            ImmutableCallSiteReference immutableCallSiteReferenceCall_site_reference = call_site_reference();
            this.state._fsp--;
            match(this.input, 3, null);
            Opcode opcodeByName = this.opcodes.getOpcodeByName(commonTree != null ? commonTree.getText() : null);
            byte[] bArr = register_list_returnVarRegister_list != null ? register_list_returnVarRegister_list.registers : null;
            this.method_stack.peek().methodBuilder.addInstruction(new BuilderInstruction35c(opcodeByName, register_list_returnVarRegister_list != null ? register_list_returnVarRegister_list.registerCount : (byte) 0, bArr[0], bArr[1], bArr[2], bArr[3], bArr[4], this.dexBuilder.internCallSite(immutableCallSiteReferenceCall_site_reference)));
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
        }
    }

    public final void insn_format35c_method() throws RecognitionException {
        try {
            match(this.input, 173, FOLLOW_I_STATEMENT_FORMAT35c_METHOD_in_insn_format35c_method3222);
            match(this.input, 2, null);
            CommonTree commonTree = (CommonTree) match(this.input, 80, FOLLOW_INSTRUCTION_FORMAT35c_METHOD_in_insn_format35c_method3224);
            pushFollow(FOLLOW_register_list_in_insn_format35c_method3226);
            register_list_return register_list_returnVarRegister_list = register_list();
            this.state._fsp--;
            pushFollow(FOLLOW_method_reference_in_insn_format35c_method3228);
            ImmutableMethodReference immutableMethodReferenceMethod_reference = method_reference();
            this.state._fsp--;
            match(this.input, 3, null);
            Opcode opcodeByName = this.opcodes.getOpcodeByName(commonTree != null ? commonTree.getText() : null);
            byte[] bArr = register_list_returnVarRegister_list != null ? register_list_returnVarRegister_list.registers : null;
            this.method_stack.peek().methodBuilder.addInstruction(new BuilderInstruction35c(opcodeByName, register_list_returnVarRegister_list != null ? register_list_returnVarRegister_list.registerCount : (byte) 0, bArr[0], bArr[1], bArr[2], bArr[3], bArr[4], this.dexBuilder.internMethodReference(immutableMethodReferenceMethod_reference)));
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
        }
    }

    public final void insn_format35c_type() throws RecognitionException {
        try {
            match(this.input, 174, FOLLOW_I_STATEMENT_FORMAT35c_TYPE_in_insn_format35c_type3251);
            match(this.input, 2, null);
            CommonTree commonTree = (CommonTree) match(this.input, 83, FOLLOW_INSTRUCTION_FORMAT35c_TYPE_in_insn_format35c_type3253);
            pushFollow(FOLLOW_register_list_in_insn_format35c_type3255);
            register_list_return register_list_returnVarRegister_list = register_list();
            this.state._fsp--;
            pushFollow(FOLLOW_nonvoid_type_descriptor_in_insn_format35c_type3257);
            nonvoid_type_descriptor_return nonvoid_type_descriptor_returnVarNonvoid_type_descriptor = nonvoid_type_descriptor();
            this.state._fsp--;
            match(this.input, 3, null);
            Opcode opcodeByName = this.opcodes.getOpcodeByName(commonTree != null ? commonTree.getText() : null);
            byte[] bArr = register_list_returnVarRegister_list != null ? register_list_returnVarRegister_list.registers : null;
            this.method_stack.peek().methodBuilder.addInstruction(new BuilderInstruction35c(opcodeByName, register_list_returnVarRegister_list != null ? register_list_returnVarRegister_list.registerCount : (byte) 0, bArr[0], bArr[1], bArr[2], bArr[3], bArr[4], this.dexBuilder.internTypeReference(nonvoid_type_descriptor_returnVarNonvoid_type_descriptor != null ? nonvoid_type_descriptor_returnVarNonvoid_type_descriptor.type : null)));
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
        }
    }

    public final void insn_format3rc_call_site() throws RecognitionException {
        try {
            match(this.input, 175, f4809x8d3d8370);
            match(this.input, 2, null);
            CommonTree commonTree = (CommonTree) match(this.input, 86, f4800x8b78a687);
            pushFollow(FOLLOW_register_range_in_insn_format3rc_call_site3289);
            register_range_return register_range_returnVarRegister_range = register_range();
            RecognizerSharedState recognizerSharedState = this.state;
            recognizerSharedState._fsp--;
            pushFollow(FOLLOW_call_site_reference_in_insn_format3rc_call_site3291);
            ImmutableCallSiteReference immutableCallSiteReferenceCall_site_reference = call_site_reference();
            RecognizerSharedState recognizerSharedState2 = this.state;
            recognizerSharedState2._fsp--;
            match(this.input, 3, null);
            Opcode opcodeByName = this.opcodes.getOpcodeByName(commonTree != null ? commonTree.getText() : null);
            int i = register_range_returnVarRegister_range != null ? register_range_returnVarRegister_range.startRegister : 0;
            this.method_stack.peek().methodBuilder.addInstruction(new BuilderInstruction3rc(opcodeByName, i, ((register_range_returnVarRegister_range != null ? register_range_returnVarRegister_range.endRegister : 0) - i) + 1, this.dexBuilder.internCallSite(immutableCallSiteReferenceCall_site_reference)));
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
        }
    }

    public final void insn_format3rc_method() throws RecognitionException {
        try {
            match(this.input, 176, FOLLOW_I_STATEMENT_FORMAT3rc_METHOD_in_insn_format3rc_method3314);
            match(this.input, 2, null);
            CommonTree commonTree = (CommonTree) match(this.input, 87, FOLLOW_INSTRUCTION_FORMAT3rc_METHOD_in_insn_format3rc_method3316);
            pushFollow(FOLLOW_register_range_in_insn_format3rc_method3318);
            register_range_return register_range_returnVarRegister_range = register_range();
            RecognizerSharedState recognizerSharedState = this.state;
            recognizerSharedState._fsp--;
            pushFollow(FOLLOW_method_reference_in_insn_format3rc_method3320);
            ImmutableMethodReference immutableMethodReferenceMethod_reference = method_reference();
            RecognizerSharedState recognizerSharedState2 = this.state;
            recognizerSharedState2._fsp--;
            match(this.input, 3, null);
            Opcode opcodeByName = this.opcodes.getOpcodeByName(commonTree != null ? commonTree.getText() : null);
            int i = register_range_returnVarRegister_range != null ? register_range_returnVarRegister_range.startRegister : 0;
            this.method_stack.peek().methodBuilder.addInstruction(new BuilderInstruction3rc(opcodeByName, i, ((register_range_returnVarRegister_range != null ? register_range_returnVarRegister_range.endRegister : 0) - i) + 1, this.dexBuilder.internMethodReference(immutableMethodReferenceMethod_reference)));
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
        }
    }

    public final void insn_format3rc_type() throws RecognitionException {
        try {
            match(this.input, 177, FOLLOW_I_STATEMENT_FORMAT3rc_TYPE_in_insn_format3rc_type3343);
            match(this.input, 2, null);
            CommonTree commonTree = (CommonTree) match(this.input, 89, FOLLOW_INSTRUCTION_FORMAT3rc_TYPE_in_insn_format3rc_type3345);
            pushFollow(FOLLOW_register_range_in_insn_format3rc_type3347);
            register_range_return register_range_returnVarRegister_range = register_range();
            RecognizerSharedState recognizerSharedState = this.state;
            recognizerSharedState._fsp--;
            pushFollow(FOLLOW_nonvoid_type_descriptor_in_insn_format3rc_type3349);
            nonvoid_type_descriptor_return nonvoid_type_descriptor_returnVarNonvoid_type_descriptor = nonvoid_type_descriptor();
            RecognizerSharedState recognizerSharedState2 = this.state;
            recognizerSharedState2._fsp--;
            match(this.input, 3, null);
            Opcode opcodeByName = this.opcodes.getOpcodeByName(commonTree != null ? commonTree.getText() : null);
            int i = register_range_returnVarRegister_range != null ? register_range_returnVarRegister_range.startRegister : 0;
            this.method_stack.peek().methodBuilder.addInstruction(new BuilderInstruction3rc(opcodeByName, i, ((register_range_returnVarRegister_range != null ? register_range_returnVarRegister_range.endRegister : 0) - i) + 1, this.dexBuilder.internTypeReference(nonvoid_type_descriptor_returnVarNonvoid_type_descriptor != null ? nonvoid_type_descriptor_returnVarNonvoid_type_descriptor.type : null)));
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
        }
    }

    public final void insn_format45cc_method() throws RecognitionException {
        try {
            match(this.input, 178, f4810x586fb6b3);
            match(this.input, 2, null);
            CommonTree commonTree = (CommonTree) match(this.input, 92, f4801xfe79ac4a);
            pushFollow(FOLLOW_register_list_in_insn_format45cc_method3376);
            register_list_return register_list_returnVarRegister_list = register_list();
            this.state._fsp--;
            pushFollow(FOLLOW_method_reference_in_insn_format45cc_method3378);
            ImmutableMethodReference immutableMethodReferenceMethod_reference = method_reference();
            this.state._fsp--;
            pushFollow(FOLLOW_method_prototype_in_insn_format45cc_method3380);
            ImmutableMethodProtoReference immutableMethodProtoReferenceMethod_prototype = method_prototype();
            this.state._fsp--;
            match(this.input, 3, null);
            Opcode opcodeByName = this.opcodes.getOpcodeByName(commonTree != null ? commonTree.getText() : null);
            byte[] bArr = register_list_returnVarRegister_list != null ? register_list_returnVarRegister_list.registers : null;
            this.method_stack.peek().methodBuilder.addInstruction(new BuilderInstruction45cc(opcodeByName, register_list_returnVarRegister_list != null ? register_list_returnVarRegister_list.registerCount : (byte) 0, bArr[0], bArr[1], bArr[2], bArr[3], bArr[4], this.dexBuilder.internMethodReference(immutableMethodReferenceMethod_reference), this.dexBuilder.internMethodProtoReference(immutableMethodProtoReferenceMethod_prototype)));
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
        }
    }

    public final void insn_format4rcc_method() throws RecognitionException {
        try {
            match(this.input, 179, f4811xec6b29a2);
            match(this.input, 2, null);
            CommonTree commonTree = (CommonTree) match(this.input, 93, f4802x92751f39);
            pushFollow(FOLLOW_register_range_in_insn_format4rcc_method3407);
            register_range_return register_range_returnVarRegister_range = register_range();
            RecognizerSharedState recognizerSharedState = this.state;
            recognizerSharedState._fsp--;
            pushFollow(FOLLOW_method_reference_in_insn_format4rcc_method3409);
            ImmutableMethodReference immutableMethodReferenceMethod_reference = method_reference();
            RecognizerSharedState recognizerSharedState2 = this.state;
            recognizerSharedState2._fsp--;
            pushFollow(FOLLOW_method_prototype_in_insn_format4rcc_method3411);
            ImmutableMethodProtoReference immutableMethodProtoReferenceMethod_prototype = method_prototype();
            RecognizerSharedState recognizerSharedState3 = this.state;
            recognizerSharedState3._fsp--;
            match(this.input, 3, null);
            Opcode opcodeByName = this.opcodes.getOpcodeByName(commonTree != null ? commonTree.getText() : null);
            int i = register_range_returnVarRegister_range != null ? register_range_returnVarRegister_range.startRegister : 0;
            this.method_stack.peek().methodBuilder.addInstruction(new BuilderInstruction4rcc(opcodeByName, i, ((register_range_returnVarRegister_range != null ? register_range_returnVarRegister_range.endRegister : 0) - i) + 1, this.dexBuilder.internMethodReference(immutableMethodReferenceMethod_reference), this.dexBuilder.internMethodProtoReference(immutableMethodProtoReferenceMethod_prototype)));
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
        }
    }

    public final void insn_format51l_type() throws RecognitionException {
        try {
            match(this.input, 180, FOLLOW_I_STATEMENT_FORMAT51l_in_insn_format51l_type3434);
            match(this.input, 2, null);
            CommonTree commonTree = (CommonTree) match(this.input, 94, FOLLOW_INSTRUCTION_FORMAT51l_in_insn_format51l_type3436);
            CommonTree commonTree2 = (CommonTree) match(this.input, 204, FOLLOW_REGISTER_in_insn_format51l_type3438);
            pushFollow(FOLLOW_fixed_64bit_literal_in_insn_format51l_type3440);
            long jFixed_64bit_literal = fixed_64bit_literal();
            RecognizerSharedState recognizerSharedState = this.state;
            recognizerSharedState._fsp--;
            match(this.input, 3, null);
            this.method_stack.peek().methodBuilder.addInstruction(new BuilderInstruction51l(this.opcodes.getOpcodeByName(commonTree != null ? commonTree.getText() : null), parseRegister_byte(commonTree2 != null ? commonTree2.getText() : null), jFixed_64bit_literal));
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
        }
    }

    public final void insn_packed_switch_directive() throws RecognitionException {
        try {
            match(this.input, 181, f4812x8c53fca9);
            match(this.input, 2, null);
            match(this.input, 132, f4805x4c89fb9f);
            match(this.input, 2, null);
            pushFollow(FOLLOW_fixed_32bit_literal_in_insn_packed_switch_directive3498);
            int iFixed_32bit_literal = fixed_32bit_literal();
            RecognizerSharedState recognizerSharedState = this.state;
            recognizerSharedState._fsp--;
            match(this.input, 3, null);
            pushFollow(f4815xf8430993);
            List<Label> listPacked_switch_elements = packed_switch_elements();
            RecognizerSharedState recognizerSharedState2 = this.state;
            recognizerSharedState2._fsp--;
            match(this.input, 3, null);
            this.method_stack.peek().methodBuilder.addInstruction(new BuilderPackedSwitchPayload(iFixed_32bit_literal, listPacked_switch_elements));
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
        }
    }

    public final void insn_sparse_switch_directive() throws RecognitionException {
        try {
            match(this.input, 182, f4813x856d6443);
            match(this.input, 2, null);
            pushFollow(f4816x24e99ed7);
            List<SwitchLabelElement> listSparse_switch_elements = sparse_switch_elements();
            RecognizerSharedState recognizerSharedState = this.state;
            recognizerSharedState._fsp--;
            match(this.input, 3, null);
            this.method_stack.peek().methodBuilder.addInstruction(new BuilderSparseSwitchPayload(listSparse_switch_elements));
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:46:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x009c A[Catch: all -> 0x0347, Exception -> 0x0349, TryCatch #0 {Exception -> 0x0349, blocks: (B:3:0x000f, B:4:0x0017, B:5:0x001a, B:87:0x033f, B:88:0x0346, B:45:0x0097, B:47:0x009c, B:48:0x00ad, B:49:0x00be, B:50:0x00cf, B:51:0x00e0, B:52:0x00f1, B:53:0x0102, B:54:0x0113, B:55:0x0124, B:56:0x0135, B:57:0x0146, B:58:0x0157, B:59:0x0168, B:60:0x0179, B:61:0x018a, B:62:0x019b, B:63:0x01ac, B:64:0x01bd, B:65:0x01ce, B:66:0x01df, B:67:0x01f0, B:68:0x0201, B:69:0x0212, B:70:0x0223, B:71:0x0234, B:72:0x0245, B:73:0x0256, B:74:0x0267, B:75:0x0278, B:76:0x0289, B:77:0x029a, B:78:0x02ab, B:79:0x02bc, B:80:0x02cd, B:81:0x02de, B:82:0x02ef, B:83:0x02ff, B:84:0x030f, B:85:0x031f, B:86:0x032f), top: B:95:0x000f, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ad A[Catch: all -> 0x0347, Exception -> 0x0349, TryCatch #0 {Exception -> 0x0349, blocks: (B:3:0x000f, B:4:0x0017, B:5:0x001a, B:87:0x033f, B:88:0x0346, B:45:0x0097, B:47:0x009c, B:48:0x00ad, B:49:0x00be, B:50:0x00cf, B:51:0x00e0, B:52:0x00f1, B:53:0x0102, B:54:0x0113, B:55:0x0124, B:56:0x0135, B:57:0x0146, B:58:0x0157, B:59:0x0168, B:60:0x0179, B:61:0x018a, B:62:0x019b, B:63:0x01ac, B:64:0x01bd, B:65:0x01ce, B:66:0x01df, B:67:0x01f0, B:68:0x0201, B:69:0x0212, B:70:0x0223, B:71:0x0234, B:72:0x0245, B:73:0x0256, B:74:0x0267, B:75:0x0278, B:76:0x0289, B:77:0x029a, B:78:0x02ab, B:79:0x02bc, B:80:0x02cd, B:81:0x02de, B:82:0x02ef, B:83:0x02ff, B:84:0x030f, B:85:0x031f, B:86:0x032f), top: B:95:0x000f, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00be A[Catch: all -> 0x0347, Exception -> 0x0349, TryCatch #0 {Exception -> 0x0349, blocks: (B:3:0x000f, B:4:0x0017, B:5:0x001a, B:87:0x033f, B:88:0x0346, B:45:0x0097, B:47:0x009c, B:48:0x00ad, B:49:0x00be, B:50:0x00cf, B:51:0x00e0, B:52:0x00f1, B:53:0x0102, B:54:0x0113, B:55:0x0124, B:56:0x0135, B:57:0x0146, B:58:0x0157, B:59:0x0168, B:60:0x0179, B:61:0x018a, B:62:0x019b, B:63:0x01ac, B:64:0x01bd, B:65:0x01ce, B:66:0x01df, B:67:0x01f0, B:68:0x0201, B:69:0x0212, B:70:0x0223, B:71:0x0234, B:72:0x0245, B:73:0x0256, B:74:0x0267, B:75:0x0278, B:76:0x0289, B:77:0x029a, B:78:0x02ab, B:79:0x02bc, B:80:0x02cd, B:81:0x02de, B:82:0x02ef, B:83:0x02ff, B:84:0x030f, B:85:0x031f, B:86:0x032f), top: B:95:0x000f, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00cf A[Catch: all -> 0x0347, Exception -> 0x0349, TryCatch #0 {Exception -> 0x0349, blocks: (B:3:0x000f, B:4:0x0017, B:5:0x001a, B:87:0x033f, B:88:0x0346, B:45:0x0097, B:47:0x009c, B:48:0x00ad, B:49:0x00be, B:50:0x00cf, B:51:0x00e0, B:52:0x00f1, B:53:0x0102, B:54:0x0113, B:55:0x0124, B:56:0x0135, B:57:0x0146, B:58:0x0157, B:59:0x0168, B:60:0x0179, B:61:0x018a, B:62:0x019b, B:63:0x01ac, B:64:0x01bd, B:65:0x01ce, B:66:0x01df, B:67:0x01f0, B:68:0x0201, B:69:0x0212, B:70:0x0223, B:71:0x0234, B:72:0x0245, B:73:0x0256, B:74:0x0267, B:75:0x0278, B:76:0x0289, B:77:0x029a, B:78:0x02ab, B:79:0x02bc, B:80:0x02cd, B:81:0x02de, B:82:0x02ef, B:83:0x02ff, B:84:0x030f, B:85:0x031f, B:86:0x032f), top: B:95:0x000f, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00e0 A[Catch: all -> 0x0347, Exception -> 0x0349, TryCatch #0 {Exception -> 0x0349, blocks: (B:3:0x000f, B:4:0x0017, B:5:0x001a, B:87:0x033f, B:88:0x0346, B:45:0x0097, B:47:0x009c, B:48:0x00ad, B:49:0x00be, B:50:0x00cf, B:51:0x00e0, B:52:0x00f1, B:53:0x0102, B:54:0x0113, B:55:0x0124, B:56:0x0135, B:57:0x0146, B:58:0x0157, B:59:0x0168, B:60:0x0179, B:61:0x018a, B:62:0x019b, B:63:0x01ac, B:64:0x01bd, B:65:0x01ce, B:66:0x01df, B:67:0x01f0, B:68:0x0201, B:69:0x0212, B:70:0x0223, B:71:0x0234, B:72:0x0245, B:73:0x0256, B:74:0x0267, B:75:0x0278, B:76:0x0289, B:77:0x029a, B:78:0x02ab, B:79:0x02bc, B:80:0x02cd, B:81:0x02de, B:82:0x02ef, B:83:0x02ff, B:84:0x030f, B:85:0x031f, B:86:0x032f), top: B:95:0x000f, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00f1 A[Catch: all -> 0x0347, Exception -> 0x0349, TryCatch #0 {Exception -> 0x0349, blocks: (B:3:0x000f, B:4:0x0017, B:5:0x001a, B:87:0x033f, B:88:0x0346, B:45:0x0097, B:47:0x009c, B:48:0x00ad, B:49:0x00be, B:50:0x00cf, B:51:0x00e0, B:52:0x00f1, B:53:0x0102, B:54:0x0113, B:55:0x0124, B:56:0x0135, B:57:0x0146, B:58:0x0157, B:59:0x0168, B:60:0x0179, B:61:0x018a, B:62:0x019b, B:63:0x01ac, B:64:0x01bd, B:65:0x01ce, B:66:0x01df, B:67:0x01f0, B:68:0x0201, B:69:0x0212, B:70:0x0223, B:71:0x0234, B:72:0x0245, B:73:0x0256, B:74:0x0267, B:75:0x0278, B:76:0x0289, B:77:0x029a, B:78:0x02ab, B:79:0x02bc, B:80:0x02cd, B:81:0x02de, B:82:0x02ef, B:83:0x02ff, B:84:0x030f, B:85:0x031f, B:86:0x032f), top: B:95:0x000f, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0102 A[Catch: all -> 0x0347, Exception -> 0x0349, TryCatch #0 {Exception -> 0x0349, blocks: (B:3:0x000f, B:4:0x0017, B:5:0x001a, B:87:0x033f, B:88:0x0346, B:45:0x0097, B:47:0x009c, B:48:0x00ad, B:49:0x00be, B:50:0x00cf, B:51:0x00e0, B:52:0x00f1, B:53:0x0102, B:54:0x0113, B:55:0x0124, B:56:0x0135, B:57:0x0146, B:58:0x0157, B:59:0x0168, B:60:0x0179, B:61:0x018a, B:62:0x019b, B:63:0x01ac, B:64:0x01bd, B:65:0x01ce, B:66:0x01df, B:67:0x01f0, B:68:0x0201, B:69:0x0212, B:70:0x0223, B:71:0x0234, B:72:0x0245, B:73:0x0256, B:74:0x0267, B:75:0x0278, B:76:0x0289, B:77:0x029a, B:78:0x02ab, B:79:0x02bc, B:80:0x02cd, B:81:0x02de, B:82:0x02ef, B:83:0x02ff, B:84:0x030f, B:85:0x031f, B:86:0x032f), top: B:95:0x000f, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0113 A[Catch: all -> 0x0347, Exception -> 0x0349, TryCatch #0 {Exception -> 0x0349, blocks: (B:3:0x000f, B:4:0x0017, B:5:0x001a, B:87:0x033f, B:88:0x0346, B:45:0x0097, B:47:0x009c, B:48:0x00ad, B:49:0x00be, B:50:0x00cf, B:51:0x00e0, B:52:0x00f1, B:53:0x0102, B:54:0x0113, B:55:0x0124, B:56:0x0135, B:57:0x0146, B:58:0x0157, B:59:0x0168, B:60:0x0179, B:61:0x018a, B:62:0x019b, B:63:0x01ac, B:64:0x01bd, B:65:0x01ce, B:66:0x01df, B:67:0x01f0, B:68:0x0201, B:69:0x0212, B:70:0x0223, B:71:0x0234, B:72:0x0245, B:73:0x0256, B:74:0x0267, B:75:0x0278, B:76:0x0289, B:77:0x029a, B:78:0x02ab, B:79:0x02bc, B:80:0x02cd, B:81:0x02de, B:82:0x02ef, B:83:0x02ff, B:84:0x030f, B:85:0x031f, B:86:0x032f), top: B:95:0x000f, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0124 A[Catch: all -> 0x0347, Exception -> 0x0349, TryCatch #0 {Exception -> 0x0349, blocks: (B:3:0x000f, B:4:0x0017, B:5:0x001a, B:87:0x033f, B:88:0x0346, B:45:0x0097, B:47:0x009c, B:48:0x00ad, B:49:0x00be, B:50:0x00cf, B:51:0x00e0, B:52:0x00f1, B:53:0x0102, B:54:0x0113, B:55:0x0124, B:56:0x0135, B:57:0x0146, B:58:0x0157, B:59:0x0168, B:60:0x0179, B:61:0x018a, B:62:0x019b, B:63:0x01ac, B:64:0x01bd, B:65:0x01ce, B:66:0x01df, B:67:0x01f0, B:68:0x0201, B:69:0x0212, B:70:0x0223, B:71:0x0234, B:72:0x0245, B:73:0x0256, B:74:0x0267, B:75:0x0278, B:76:0x0289, B:77:0x029a, B:78:0x02ab, B:79:0x02bc, B:80:0x02cd, B:81:0x02de, B:82:0x02ef, B:83:0x02ff, B:84:0x030f, B:85:0x031f, B:86:0x032f), top: B:95:0x000f, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0135 A[Catch: all -> 0x0347, Exception -> 0x0349, TryCatch #0 {Exception -> 0x0349, blocks: (B:3:0x000f, B:4:0x0017, B:5:0x001a, B:87:0x033f, B:88:0x0346, B:45:0x0097, B:47:0x009c, B:48:0x00ad, B:49:0x00be, B:50:0x00cf, B:51:0x00e0, B:52:0x00f1, B:53:0x0102, B:54:0x0113, B:55:0x0124, B:56:0x0135, B:57:0x0146, B:58:0x0157, B:59:0x0168, B:60:0x0179, B:61:0x018a, B:62:0x019b, B:63:0x01ac, B:64:0x01bd, B:65:0x01ce, B:66:0x01df, B:67:0x01f0, B:68:0x0201, B:69:0x0212, B:70:0x0223, B:71:0x0234, B:72:0x0245, B:73:0x0256, B:74:0x0267, B:75:0x0278, B:76:0x0289, B:77:0x029a, B:78:0x02ab, B:79:0x02bc, B:80:0x02cd, B:81:0x02de, B:82:0x02ef, B:83:0x02ff, B:84:0x030f, B:85:0x031f, B:86:0x032f), top: B:95:0x000f, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0146 A[Catch: all -> 0x0347, Exception -> 0x0349, TryCatch #0 {Exception -> 0x0349, blocks: (B:3:0x000f, B:4:0x0017, B:5:0x001a, B:87:0x033f, B:88:0x0346, B:45:0x0097, B:47:0x009c, B:48:0x00ad, B:49:0x00be, B:50:0x00cf, B:51:0x00e0, B:52:0x00f1, B:53:0x0102, B:54:0x0113, B:55:0x0124, B:56:0x0135, B:57:0x0146, B:58:0x0157, B:59:0x0168, B:60:0x0179, B:61:0x018a, B:62:0x019b, B:63:0x01ac, B:64:0x01bd, B:65:0x01ce, B:66:0x01df, B:67:0x01f0, B:68:0x0201, B:69:0x0212, B:70:0x0223, B:71:0x0234, B:72:0x0245, B:73:0x0256, B:74:0x0267, B:75:0x0278, B:76:0x0289, B:77:0x029a, B:78:0x02ab, B:79:0x02bc, B:80:0x02cd, B:81:0x02de, B:82:0x02ef, B:83:0x02ff, B:84:0x030f, B:85:0x031f, B:86:0x032f), top: B:95:0x000f, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0157 A[Catch: all -> 0x0347, Exception -> 0x0349, TryCatch #0 {Exception -> 0x0349, blocks: (B:3:0x000f, B:4:0x0017, B:5:0x001a, B:87:0x033f, B:88:0x0346, B:45:0x0097, B:47:0x009c, B:48:0x00ad, B:49:0x00be, B:50:0x00cf, B:51:0x00e0, B:52:0x00f1, B:53:0x0102, B:54:0x0113, B:55:0x0124, B:56:0x0135, B:57:0x0146, B:58:0x0157, B:59:0x0168, B:60:0x0179, B:61:0x018a, B:62:0x019b, B:63:0x01ac, B:64:0x01bd, B:65:0x01ce, B:66:0x01df, B:67:0x01f0, B:68:0x0201, B:69:0x0212, B:70:0x0223, B:71:0x0234, B:72:0x0245, B:73:0x0256, B:74:0x0267, B:75:0x0278, B:76:0x0289, B:77:0x029a, B:78:0x02ab, B:79:0x02bc, B:80:0x02cd, B:81:0x02de, B:82:0x02ef, B:83:0x02ff, B:84:0x030f, B:85:0x031f, B:86:0x032f), top: B:95:0x000f, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0168 A[Catch: all -> 0x0347, Exception -> 0x0349, TryCatch #0 {Exception -> 0x0349, blocks: (B:3:0x000f, B:4:0x0017, B:5:0x001a, B:87:0x033f, B:88:0x0346, B:45:0x0097, B:47:0x009c, B:48:0x00ad, B:49:0x00be, B:50:0x00cf, B:51:0x00e0, B:52:0x00f1, B:53:0x0102, B:54:0x0113, B:55:0x0124, B:56:0x0135, B:57:0x0146, B:58:0x0157, B:59:0x0168, B:60:0x0179, B:61:0x018a, B:62:0x019b, B:63:0x01ac, B:64:0x01bd, B:65:0x01ce, B:66:0x01df, B:67:0x01f0, B:68:0x0201, B:69:0x0212, B:70:0x0223, B:71:0x0234, B:72:0x0245, B:73:0x0256, B:74:0x0267, B:75:0x0278, B:76:0x0289, B:77:0x029a, B:78:0x02ab, B:79:0x02bc, B:80:0x02cd, B:81:0x02de, B:82:0x02ef, B:83:0x02ff, B:84:0x030f, B:85:0x031f, B:86:0x032f), top: B:95:0x000f, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0179 A[Catch: all -> 0x0347, Exception -> 0x0349, TryCatch #0 {Exception -> 0x0349, blocks: (B:3:0x000f, B:4:0x0017, B:5:0x001a, B:87:0x033f, B:88:0x0346, B:45:0x0097, B:47:0x009c, B:48:0x00ad, B:49:0x00be, B:50:0x00cf, B:51:0x00e0, B:52:0x00f1, B:53:0x0102, B:54:0x0113, B:55:0x0124, B:56:0x0135, B:57:0x0146, B:58:0x0157, B:59:0x0168, B:60:0x0179, B:61:0x018a, B:62:0x019b, B:63:0x01ac, B:64:0x01bd, B:65:0x01ce, B:66:0x01df, B:67:0x01f0, B:68:0x0201, B:69:0x0212, B:70:0x0223, B:71:0x0234, B:72:0x0245, B:73:0x0256, B:74:0x0267, B:75:0x0278, B:76:0x0289, B:77:0x029a, B:78:0x02ab, B:79:0x02bc, B:80:0x02cd, B:81:0x02de, B:82:0x02ef, B:83:0x02ff, B:84:0x030f, B:85:0x031f, B:86:0x032f), top: B:95:0x000f, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x018a A[Catch: all -> 0x0347, Exception -> 0x0349, TryCatch #0 {Exception -> 0x0349, blocks: (B:3:0x000f, B:4:0x0017, B:5:0x001a, B:87:0x033f, B:88:0x0346, B:45:0x0097, B:47:0x009c, B:48:0x00ad, B:49:0x00be, B:50:0x00cf, B:51:0x00e0, B:52:0x00f1, B:53:0x0102, B:54:0x0113, B:55:0x0124, B:56:0x0135, B:57:0x0146, B:58:0x0157, B:59:0x0168, B:60:0x0179, B:61:0x018a, B:62:0x019b, B:63:0x01ac, B:64:0x01bd, B:65:0x01ce, B:66:0x01df, B:67:0x01f0, B:68:0x0201, B:69:0x0212, B:70:0x0223, B:71:0x0234, B:72:0x0245, B:73:0x0256, B:74:0x0267, B:75:0x0278, B:76:0x0289, B:77:0x029a, B:78:0x02ab, B:79:0x02bc, B:80:0x02cd, B:81:0x02de, B:82:0x02ef, B:83:0x02ff, B:84:0x030f, B:85:0x031f, B:86:0x032f), top: B:95:0x000f, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x019b A[Catch: all -> 0x0347, Exception -> 0x0349, TryCatch #0 {Exception -> 0x0349, blocks: (B:3:0x000f, B:4:0x0017, B:5:0x001a, B:87:0x033f, B:88:0x0346, B:45:0x0097, B:47:0x009c, B:48:0x00ad, B:49:0x00be, B:50:0x00cf, B:51:0x00e0, B:52:0x00f1, B:53:0x0102, B:54:0x0113, B:55:0x0124, B:56:0x0135, B:57:0x0146, B:58:0x0157, B:59:0x0168, B:60:0x0179, B:61:0x018a, B:62:0x019b, B:63:0x01ac, B:64:0x01bd, B:65:0x01ce, B:66:0x01df, B:67:0x01f0, B:68:0x0201, B:69:0x0212, B:70:0x0223, B:71:0x0234, B:72:0x0245, B:73:0x0256, B:74:0x0267, B:75:0x0278, B:76:0x0289, B:77:0x029a, B:78:0x02ab, B:79:0x02bc, B:80:0x02cd, B:81:0x02de, B:82:0x02ef, B:83:0x02ff, B:84:0x030f, B:85:0x031f, B:86:0x032f), top: B:95:0x000f, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01ac A[Catch: all -> 0x0347, Exception -> 0x0349, TryCatch #0 {Exception -> 0x0349, blocks: (B:3:0x000f, B:4:0x0017, B:5:0x001a, B:87:0x033f, B:88:0x0346, B:45:0x0097, B:47:0x009c, B:48:0x00ad, B:49:0x00be, B:50:0x00cf, B:51:0x00e0, B:52:0x00f1, B:53:0x0102, B:54:0x0113, B:55:0x0124, B:56:0x0135, B:57:0x0146, B:58:0x0157, B:59:0x0168, B:60:0x0179, B:61:0x018a, B:62:0x019b, B:63:0x01ac, B:64:0x01bd, B:65:0x01ce, B:66:0x01df, B:67:0x01f0, B:68:0x0201, B:69:0x0212, B:70:0x0223, B:71:0x0234, B:72:0x0245, B:73:0x0256, B:74:0x0267, B:75:0x0278, B:76:0x0289, B:77:0x029a, B:78:0x02ab, B:79:0x02bc, B:80:0x02cd, B:81:0x02de, B:82:0x02ef, B:83:0x02ff, B:84:0x030f, B:85:0x031f, B:86:0x032f), top: B:95:0x000f, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01bd A[Catch: all -> 0x0347, Exception -> 0x0349, TryCatch #0 {Exception -> 0x0349, blocks: (B:3:0x000f, B:4:0x0017, B:5:0x001a, B:87:0x033f, B:88:0x0346, B:45:0x0097, B:47:0x009c, B:48:0x00ad, B:49:0x00be, B:50:0x00cf, B:51:0x00e0, B:52:0x00f1, B:53:0x0102, B:54:0x0113, B:55:0x0124, B:56:0x0135, B:57:0x0146, B:58:0x0157, B:59:0x0168, B:60:0x0179, B:61:0x018a, B:62:0x019b, B:63:0x01ac, B:64:0x01bd, B:65:0x01ce, B:66:0x01df, B:67:0x01f0, B:68:0x0201, B:69:0x0212, B:70:0x0223, B:71:0x0234, B:72:0x0245, B:73:0x0256, B:74:0x0267, B:75:0x0278, B:76:0x0289, B:77:0x029a, B:78:0x02ab, B:79:0x02bc, B:80:0x02cd, B:81:0x02de, B:82:0x02ef, B:83:0x02ff, B:84:0x030f, B:85:0x031f, B:86:0x032f), top: B:95:0x000f, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01ce A[Catch: all -> 0x0347, Exception -> 0x0349, TryCatch #0 {Exception -> 0x0349, blocks: (B:3:0x000f, B:4:0x0017, B:5:0x001a, B:87:0x033f, B:88:0x0346, B:45:0x0097, B:47:0x009c, B:48:0x00ad, B:49:0x00be, B:50:0x00cf, B:51:0x00e0, B:52:0x00f1, B:53:0x0102, B:54:0x0113, B:55:0x0124, B:56:0x0135, B:57:0x0146, B:58:0x0157, B:59:0x0168, B:60:0x0179, B:61:0x018a, B:62:0x019b, B:63:0x01ac, B:64:0x01bd, B:65:0x01ce, B:66:0x01df, B:67:0x01f0, B:68:0x0201, B:69:0x0212, B:70:0x0223, B:71:0x0234, B:72:0x0245, B:73:0x0256, B:74:0x0267, B:75:0x0278, B:76:0x0289, B:77:0x029a, B:78:0x02ab, B:79:0x02bc, B:80:0x02cd, B:81:0x02de, B:82:0x02ef, B:83:0x02ff, B:84:0x030f, B:85:0x031f, B:86:0x032f), top: B:95:0x000f, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01df A[Catch: all -> 0x0347, Exception -> 0x0349, TryCatch #0 {Exception -> 0x0349, blocks: (B:3:0x000f, B:4:0x0017, B:5:0x001a, B:87:0x033f, B:88:0x0346, B:45:0x0097, B:47:0x009c, B:48:0x00ad, B:49:0x00be, B:50:0x00cf, B:51:0x00e0, B:52:0x00f1, B:53:0x0102, B:54:0x0113, B:55:0x0124, B:56:0x0135, B:57:0x0146, B:58:0x0157, B:59:0x0168, B:60:0x0179, B:61:0x018a, B:62:0x019b, B:63:0x01ac, B:64:0x01bd, B:65:0x01ce, B:66:0x01df, B:67:0x01f0, B:68:0x0201, B:69:0x0212, B:70:0x0223, B:71:0x0234, B:72:0x0245, B:73:0x0256, B:74:0x0267, B:75:0x0278, B:76:0x0289, B:77:0x029a, B:78:0x02ab, B:79:0x02bc, B:80:0x02cd, B:81:0x02de, B:82:0x02ef, B:83:0x02ff, B:84:0x030f, B:85:0x031f, B:86:0x032f), top: B:95:0x000f, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01f0 A[Catch: all -> 0x0347, Exception -> 0x0349, TryCatch #0 {Exception -> 0x0349, blocks: (B:3:0x000f, B:4:0x0017, B:5:0x001a, B:87:0x033f, B:88:0x0346, B:45:0x0097, B:47:0x009c, B:48:0x00ad, B:49:0x00be, B:50:0x00cf, B:51:0x00e0, B:52:0x00f1, B:53:0x0102, B:54:0x0113, B:55:0x0124, B:56:0x0135, B:57:0x0146, B:58:0x0157, B:59:0x0168, B:60:0x0179, B:61:0x018a, B:62:0x019b, B:63:0x01ac, B:64:0x01bd, B:65:0x01ce, B:66:0x01df, B:67:0x01f0, B:68:0x0201, B:69:0x0212, B:70:0x0223, B:71:0x0234, B:72:0x0245, B:73:0x0256, B:74:0x0267, B:75:0x0278, B:76:0x0289, B:77:0x029a, B:78:0x02ab, B:79:0x02bc, B:80:0x02cd, B:81:0x02de, B:82:0x02ef, B:83:0x02ff, B:84:0x030f, B:85:0x031f, B:86:0x032f), top: B:95:0x000f, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0201 A[Catch: all -> 0x0347, Exception -> 0x0349, TryCatch #0 {Exception -> 0x0349, blocks: (B:3:0x000f, B:4:0x0017, B:5:0x001a, B:87:0x033f, B:88:0x0346, B:45:0x0097, B:47:0x009c, B:48:0x00ad, B:49:0x00be, B:50:0x00cf, B:51:0x00e0, B:52:0x00f1, B:53:0x0102, B:54:0x0113, B:55:0x0124, B:56:0x0135, B:57:0x0146, B:58:0x0157, B:59:0x0168, B:60:0x0179, B:61:0x018a, B:62:0x019b, B:63:0x01ac, B:64:0x01bd, B:65:0x01ce, B:66:0x01df, B:67:0x01f0, B:68:0x0201, B:69:0x0212, B:70:0x0223, B:71:0x0234, B:72:0x0245, B:73:0x0256, B:74:0x0267, B:75:0x0278, B:76:0x0289, B:77:0x029a, B:78:0x02ab, B:79:0x02bc, B:80:0x02cd, B:81:0x02de, B:82:0x02ef, B:83:0x02ff, B:84:0x030f, B:85:0x031f, B:86:0x032f), top: B:95:0x000f, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0212 A[Catch: all -> 0x0347, Exception -> 0x0349, TryCatch #0 {Exception -> 0x0349, blocks: (B:3:0x000f, B:4:0x0017, B:5:0x001a, B:87:0x033f, B:88:0x0346, B:45:0x0097, B:47:0x009c, B:48:0x00ad, B:49:0x00be, B:50:0x00cf, B:51:0x00e0, B:52:0x00f1, B:53:0x0102, B:54:0x0113, B:55:0x0124, B:56:0x0135, B:57:0x0146, B:58:0x0157, B:59:0x0168, B:60:0x0179, B:61:0x018a, B:62:0x019b, B:63:0x01ac, B:64:0x01bd, B:65:0x01ce, B:66:0x01df, B:67:0x01f0, B:68:0x0201, B:69:0x0212, B:70:0x0223, B:71:0x0234, B:72:0x0245, B:73:0x0256, B:74:0x0267, B:75:0x0278, B:76:0x0289, B:77:0x029a, B:78:0x02ab, B:79:0x02bc, B:80:0x02cd, B:81:0x02de, B:82:0x02ef, B:83:0x02ff, B:84:0x030f, B:85:0x031f, B:86:0x032f), top: B:95:0x000f, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0223 A[Catch: all -> 0x0347, Exception -> 0x0349, TryCatch #0 {Exception -> 0x0349, blocks: (B:3:0x000f, B:4:0x0017, B:5:0x001a, B:87:0x033f, B:88:0x0346, B:45:0x0097, B:47:0x009c, B:48:0x00ad, B:49:0x00be, B:50:0x00cf, B:51:0x00e0, B:52:0x00f1, B:53:0x0102, B:54:0x0113, B:55:0x0124, B:56:0x0135, B:57:0x0146, B:58:0x0157, B:59:0x0168, B:60:0x0179, B:61:0x018a, B:62:0x019b, B:63:0x01ac, B:64:0x01bd, B:65:0x01ce, B:66:0x01df, B:67:0x01f0, B:68:0x0201, B:69:0x0212, B:70:0x0223, B:71:0x0234, B:72:0x0245, B:73:0x0256, B:74:0x0267, B:75:0x0278, B:76:0x0289, B:77:0x029a, B:78:0x02ab, B:79:0x02bc, B:80:0x02cd, B:81:0x02de, B:82:0x02ef, B:83:0x02ff, B:84:0x030f, B:85:0x031f, B:86:0x032f), top: B:95:0x000f, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0234 A[Catch: all -> 0x0347, Exception -> 0x0349, TryCatch #0 {Exception -> 0x0349, blocks: (B:3:0x000f, B:4:0x0017, B:5:0x001a, B:87:0x033f, B:88:0x0346, B:45:0x0097, B:47:0x009c, B:48:0x00ad, B:49:0x00be, B:50:0x00cf, B:51:0x00e0, B:52:0x00f1, B:53:0x0102, B:54:0x0113, B:55:0x0124, B:56:0x0135, B:57:0x0146, B:58:0x0157, B:59:0x0168, B:60:0x0179, B:61:0x018a, B:62:0x019b, B:63:0x01ac, B:64:0x01bd, B:65:0x01ce, B:66:0x01df, B:67:0x01f0, B:68:0x0201, B:69:0x0212, B:70:0x0223, B:71:0x0234, B:72:0x0245, B:73:0x0256, B:74:0x0267, B:75:0x0278, B:76:0x0289, B:77:0x029a, B:78:0x02ab, B:79:0x02bc, B:80:0x02cd, B:81:0x02de, B:82:0x02ef, B:83:0x02ff, B:84:0x030f, B:85:0x031f, B:86:0x032f), top: B:95:0x000f, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0245 A[Catch: all -> 0x0347, Exception -> 0x0349, TryCatch #0 {Exception -> 0x0349, blocks: (B:3:0x000f, B:4:0x0017, B:5:0x001a, B:87:0x033f, B:88:0x0346, B:45:0x0097, B:47:0x009c, B:48:0x00ad, B:49:0x00be, B:50:0x00cf, B:51:0x00e0, B:52:0x00f1, B:53:0x0102, B:54:0x0113, B:55:0x0124, B:56:0x0135, B:57:0x0146, B:58:0x0157, B:59:0x0168, B:60:0x0179, B:61:0x018a, B:62:0x019b, B:63:0x01ac, B:64:0x01bd, B:65:0x01ce, B:66:0x01df, B:67:0x01f0, B:68:0x0201, B:69:0x0212, B:70:0x0223, B:71:0x0234, B:72:0x0245, B:73:0x0256, B:74:0x0267, B:75:0x0278, B:76:0x0289, B:77:0x029a, B:78:0x02ab, B:79:0x02bc, B:80:0x02cd, B:81:0x02de, B:82:0x02ef, B:83:0x02ff, B:84:0x030f, B:85:0x031f, B:86:0x032f), top: B:95:0x000f, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0256 A[Catch: all -> 0x0347, Exception -> 0x0349, TryCatch #0 {Exception -> 0x0349, blocks: (B:3:0x000f, B:4:0x0017, B:5:0x001a, B:87:0x033f, B:88:0x0346, B:45:0x0097, B:47:0x009c, B:48:0x00ad, B:49:0x00be, B:50:0x00cf, B:51:0x00e0, B:52:0x00f1, B:53:0x0102, B:54:0x0113, B:55:0x0124, B:56:0x0135, B:57:0x0146, B:58:0x0157, B:59:0x0168, B:60:0x0179, B:61:0x018a, B:62:0x019b, B:63:0x01ac, B:64:0x01bd, B:65:0x01ce, B:66:0x01df, B:67:0x01f0, B:68:0x0201, B:69:0x0212, B:70:0x0223, B:71:0x0234, B:72:0x0245, B:73:0x0256, B:74:0x0267, B:75:0x0278, B:76:0x0289, B:77:0x029a, B:78:0x02ab, B:79:0x02bc, B:80:0x02cd, B:81:0x02de, B:82:0x02ef, B:83:0x02ff, B:84:0x030f, B:85:0x031f, B:86:0x032f), top: B:95:0x000f, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0267 A[Catch: all -> 0x0347, Exception -> 0x0349, TryCatch #0 {Exception -> 0x0349, blocks: (B:3:0x000f, B:4:0x0017, B:5:0x001a, B:87:0x033f, B:88:0x0346, B:45:0x0097, B:47:0x009c, B:48:0x00ad, B:49:0x00be, B:50:0x00cf, B:51:0x00e0, B:52:0x00f1, B:53:0x0102, B:54:0x0113, B:55:0x0124, B:56:0x0135, B:57:0x0146, B:58:0x0157, B:59:0x0168, B:60:0x0179, B:61:0x018a, B:62:0x019b, B:63:0x01ac, B:64:0x01bd, B:65:0x01ce, B:66:0x01df, B:67:0x01f0, B:68:0x0201, B:69:0x0212, B:70:0x0223, B:71:0x0234, B:72:0x0245, B:73:0x0256, B:74:0x0267, B:75:0x0278, B:76:0x0289, B:77:0x029a, B:78:0x02ab, B:79:0x02bc, B:80:0x02cd, B:81:0x02de, B:82:0x02ef, B:83:0x02ff, B:84:0x030f, B:85:0x031f, B:86:0x032f), top: B:95:0x000f, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0278 A[Catch: all -> 0x0347, Exception -> 0x0349, TryCatch #0 {Exception -> 0x0349, blocks: (B:3:0x000f, B:4:0x0017, B:5:0x001a, B:87:0x033f, B:88:0x0346, B:45:0x0097, B:47:0x009c, B:48:0x00ad, B:49:0x00be, B:50:0x00cf, B:51:0x00e0, B:52:0x00f1, B:53:0x0102, B:54:0x0113, B:55:0x0124, B:56:0x0135, B:57:0x0146, B:58:0x0157, B:59:0x0168, B:60:0x0179, B:61:0x018a, B:62:0x019b, B:63:0x01ac, B:64:0x01bd, B:65:0x01ce, B:66:0x01df, B:67:0x01f0, B:68:0x0201, B:69:0x0212, B:70:0x0223, B:71:0x0234, B:72:0x0245, B:73:0x0256, B:74:0x0267, B:75:0x0278, B:76:0x0289, B:77:0x029a, B:78:0x02ab, B:79:0x02bc, B:80:0x02cd, B:81:0x02de, B:82:0x02ef, B:83:0x02ff, B:84:0x030f, B:85:0x031f, B:86:0x032f), top: B:95:0x000f, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0289 A[Catch: all -> 0x0347, Exception -> 0x0349, TryCatch #0 {Exception -> 0x0349, blocks: (B:3:0x000f, B:4:0x0017, B:5:0x001a, B:87:0x033f, B:88:0x0346, B:45:0x0097, B:47:0x009c, B:48:0x00ad, B:49:0x00be, B:50:0x00cf, B:51:0x00e0, B:52:0x00f1, B:53:0x0102, B:54:0x0113, B:55:0x0124, B:56:0x0135, B:57:0x0146, B:58:0x0157, B:59:0x0168, B:60:0x0179, B:61:0x018a, B:62:0x019b, B:63:0x01ac, B:64:0x01bd, B:65:0x01ce, B:66:0x01df, B:67:0x01f0, B:68:0x0201, B:69:0x0212, B:70:0x0223, B:71:0x0234, B:72:0x0245, B:73:0x0256, B:74:0x0267, B:75:0x0278, B:76:0x0289, B:77:0x029a, B:78:0x02ab, B:79:0x02bc, B:80:0x02cd, B:81:0x02de, B:82:0x02ef, B:83:0x02ff, B:84:0x030f, B:85:0x031f, B:86:0x032f), top: B:95:0x000f, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x029a A[Catch: all -> 0x0347, Exception -> 0x0349, TryCatch #0 {Exception -> 0x0349, blocks: (B:3:0x000f, B:4:0x0017, B:5:0x001a, B:87:0x033f, B:88:0x0346, B:45:0x0097, B:47:0x009c, B:48:0x00ad, B:49:0x00be, B:50:0x00cf, B:51:0x00e0, B:52:0x00f1, B:53:0x0102, B:54:0x0113, B:55:0x0124, B:56:0x0135, B:57:0x0146, B:58:0x0157, B:59:0x0168, B:60:0x0179, B:61:0x018a, B:62:0x019b, B:63:0x01ac, B:64:0x01bd, B:65:0x01ce, B:66:0x01df, B:67:0x01f0, B:68:0x0201, B:69:0x0212, B:70:0x0223, B:71:0x0234, B:72:0x0245, B:73:0x0256, B:74:0x0267, B:75:0x0278, B:76:0x0289, B:77:0x029a, B:78:0x02ab, B:79:0x02bc, B:80:0x02cd, B:81:0x02de, B:82:0x02ef, B:83:0x02ff, B:84:0x030f, B:85:0x031f, B:86:0x032f), top: B:95:0x000f, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x02ab A[Catch: all -> 0x0347, Exception -> 0x0349, TryCatch #0 {Exception -> 0x0349, blocks: (B:3:0x000f, B:4:0x0017, B:5:0x001a, B:87:0x033f, B:88:0x0346, B:45:0x0097, B:47:0x009c, B:48:0x00ad, B:49:0x00be, B:50:0x00cf, B:51:0x00e0, B:52:0x00f1, B:53:0x0102, B:54:0x0113, B:55:0x0124, B:56:0x0135, B:57:0x0146, B:58:0x0157, B:59:0x0168, B:60:0x0179, B:61:0x018a, B:62:0x019b, B:63:0x01ac, B:64:0x01bd, B:65:0x01ce, B:66:0x01df, B:67:0x01f0, B:68:0x0201, B:69:0x0212, B:70:0x0223, B:71:0x0234, B:72:0x0245, B:73:0x0256, B:74:0x0267, B:75:0x0278, B:76:0x0289, B:77:0x029a, B:78:0x02ab, B:79:0x02bc, B:80:0x02cd, B:81:0x02de, B:82:0x02ef, B:83:0x02ff, B:84:0x030f, B:85:0x031f, B:86:0x032f), top: B:95:0x000f, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x02bc A[Catch: all -> 0x0347, Exception -> 0x0349, TryCatch #0 {Exception -> 0x0349, blocks: (B:3:0x000f, B:4:0x0017, B:5:0x001a, B:87:0x033f, B:88:0x0346, B:45:0x0097, B:47:0x009c, B:48:0x00ad, B:49:0x00be, B:50:0x00cf, B:51:0x00e0, B:52:0x00f1, B:53:0x0102, B:54:0x0113, B:55:0x0124, B:56:0x0135, B:57:0x0146, B:58:0x0157, B:59:0x0168, B:60:0x0179, B:61:0x018a, B:62:0x019b, B:63:0x01ac, B:64:0x01bd, B:65:0x01ce, B:66:0x01df, B:67:0x01f0, B:68:0x0201, B:69:0x0212, B:70:0x0223, B:71:0x0234, B:72:0x0245, B:73:0x0256, B:74:0x0267, B:75:0x0278, B:76:0x0289, B:77:0x029a, B:78:0x02ab, B:79:0x02bc, B:80:0x02cd, B:81:0x02de, B:82:0x02ef, B:83:0x02ff, B:84:0x030f, B:85:0x031f, B:86:0x032f), top: B:95:0x000f, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x02cd A[Catch: all -> 0x0347, Exception -> 0x0349, TryCatch #0 {Exception -> 0x0349, blocks: (B:3:0x000f, B:4:0x0017, B:5:0x001a, B:87:0x033f, B:88:0x0346, B:45:0x0097, B:47:0x009c, B:48:0x00ad, B:49:0x00be, B:50:0x00cf, B:51:0x00e0, B:52:0x00f1, B:53:0x0102, B:54:0x0113, B:55:0x0124, B:56:0x0135, B:57:0x0146, B:58:0x0157, B:59:0x0168, B:60:0x0179, B:61:0x018a, B:62:0x019b, B:63:0x01ac, B:64:0x01bd, B:65:0x01ce, B:66:0x01df, B:67:0x01f0, B:68:0x0201, B:69:0x0212, B:70:0x0223, B:71:0x0234, B:72:0x0245, B:73:0x0256, B:74:0x0267, B:75:0x0278, B:76:0x0289, B:77:0x029a, B:78:0x02ab, B:79:0x02bc, B:80:0x02cd, B:81:0x02de, B:82:0x02ef, B:83:0x02ff, B:84:0x030f, B:85:0x031f, B:86:0x032f), top: B:95:0x000f, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x02de A[Catch: all -> 0x0347, Exception -> 0x0349, TryCatch #0 {Exception -> 0x0349, blocks: (B:3:0x000f, B:4:0x0017, B:5:0x001a, B:87:0x033f, B:88:0x0346, B:45:0x0097, B:47:0x009c, B:48:0x00ad, B:49:0x00be, B:50:0x00cf, B:51:0x00e0, B:52:0x00f1, B:53:0x0102, B:54:0x0113, B:55:0x0124, B:56:0x0135, B:57:0x0146, B:58:0x0157, B:59:0x0168, B:60:0x0179, B:61:0x018a, B:62:0x019b, B:63:0x01ac, B:64:0x01bd, B:65:0x01ce, B:66:0x01df, B:67:0x01f0, B:68:0x0201, B:69:0x0212, B:70:0x0223, B:71:0x0234, B:72:0x0245, B:73:0x0256, B:74:0x0267, B:75:0x0278, B:76:0x0289, B:77:0x029a, B:78:0x02ab, B:79:0x02bc, B:80:0x02cd, B:81:0x02de, B:82:0x02ef, B:83:0x02ff, B:84:0x030f, B:85:0x031f, B:86:0x032f), top: B:95:0x000f, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x02ef A[Catch: all -> 0x0347, Exception -> 0x0349, TryCatch #0 {Exception -> 0x0349, blocks: (B:3:0x000f, B:4:0x0017, B:5:0x001a, B:87:0x033f, B:88:0x0346, B:45:0x0097, B:47:0x009c, B:48:0x00ad, B:49:0x00be, B:50:0x00cf, B:51:0x00e0, B:52:0x00f1, B:53:0x0102, B:54:0x0113, B:55:0x0124, B:56:0x0135, B:57:0x0146, B:58:0x0157, B:59:0x0168, B:60:0x0179, B:61:0x018a, B:62:0x019b, B:63:0x01ac, B:64:0x01bd, B:65:0x01ce, B:66:0x01df, B:67:0x01f0, B:68:0x0201, B:69:0x0212, B:70:0x0223, B:71:0x0234, B:72:0x0245, B:73:0x0256, B:74:0x0267, B:75:0x0278, B:76:0x0289, B:77:0x029a, B:78:0x02ab, B:79:0x02bc, B:80:0x02cd, B:81:0x02de, B:82:0x02ef, B:83:0x02ff, B:84:0x030f, B:85:0x031f, B:86:0x032f), top: B:95:0x000f, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x02ff A[Catch: all -> 0x0347, Exception -> 0x0349, TryCatch #0 {Exception -> 0x0349, blocks: (B:3:0x000f, B:4:0x0017, B:5:0x001a, B:87:0x033f, B:88:0x0346, B:45:0x0097, B:47:0x009c, B:48:0x00ad, B:49:0x00be, B:50:0x00cf, B:51:0x00e0, B:52:0x00f1, B:53:0x0102, B:54:0x0113, B:55:0x0124, B:56:0x0135, B:57:0x0146, B:58:0x0157, B:59:0x0168, B:60:0x0179, B:61:0x018a, B:62:0x019b, B:63:0x01ac, B:64:0x01bd, B:65:0x01ce, B:66:0x01df, B:67:0x01f0, B:68:0x0201, B:69:0x0212, B:70:0x0223, B:71:0x0234, B:72:0x0245, B:73:0x0256, B:74:0x0267, B:75:0x0278, B:76:0x0289, B:77:0x029a, B:78:0x02ab, B:79:0x02bc, B:80:0x02cd, B:81:0x02de, B:82:0x02ef, B:83:0x02ff, B:84:0x030f, B:85:0x031f, B:86:0x032f), top: B:95:0x000f, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x030f A[Catch: all -> 0x0347, Exception -> 0x0349, TryCatch #0 {Exception -> 0x0349, blocks: (B:3:0x000f, B:4:0x0017, B:5:0x001a, B:87:0x033f, B:88:0x0346, B:45:0x0097, B:47:0x009c, B:48:0x00ad, B:49:0x00be, B:50:0x00cf, B:51:0x00e0, B:52:0x00f1, B:53:0x0102, B:54:0x0113, B:55:0x0124, B:56:0x0135, B:57:0x0146, B:58:0x0157, B:59:0x0168, B:60:0x0179, B:61:0x018a, B:62:0x019b, B:63:0x01ac, B:64:0x01bd, B:65:0x01ce, B:66:0x01df, B:67:0x01f0, B:68:0x0201, B:69:0x0212, B:70:0x0223, B:71:0x0234, B:72:0x0245, B:73:0x0256, B:74:0x0267, B:75:0x0278, B:76:0x0289, B:77:0x029a, B:78:0x02ab, B:79:0x02bc, B:80:0x02cd, B:81:0x02de, B:82:0x02ef, B:83:0x02ff, B:84:0x030f, B:85:0x031f, B:86:0x032f), top: B:95:0x000f, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x031f A[Catch: all -> 0x0347, Exception -> 0x0349, TryCatch #0 {Exception -> 0x0349, blocks: (B:3:0x000f, B:4:0x0017, B:5:0x001a, B:87:0x033f, B:88:0x0346, B:45:0x0097, B:47:0x009c, B:48:0x00ad, B:49:0x00be, B:50:0x00cf, B:51:0x00e0, B:52:0x00f1, B:53:0x0102, B:54:0x0113, B:55:0x0124, B:56:0x0135, B:57:0x0146, B:58:0x0157, B:59:0x0168, B:60:0x0179, B:61:0x018a, B:62:0x019b, B:63:0x01ac, B:64:0x01bd, B:65:0x01ce, B:66:0x01df, B:67:0x01f0, B:68:0x0201, B:69:0x0212, B:70:0x0223, B:71:0x0234, B:72:0x0245, B:73:0x0256, B:74:0x0267, B:75:0x0278, B:76:0x0289, B:77:0x029a, B:78:0x02ab, B:79:0x02bc, B:80:0x02cd, B:81:0x02de, B:82:0x02ef, B:83:0x02ff, B:84:0x030f, B:85:0x031f, B:86:0x032f), top: B:95:0x000f, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x032f A[Catch: all -> 0x0347, Exception -> 0x0349, TryCatch #0 {Exception -> 0x0349, blocks: (B:3:0x000f, B:4:0x0017, B:5:0x001a, B:87:0x033f, B:88:0x0346, B:45:0x0097, B:47:0x009c, B:48:0x00ad, B:49:0x00be, B:50:0x00cf, B:51:0x00e0, B:52:0x00f1, B:53:0x0102, B:54:0x0113, B:55:0x0124, B:56:0x0135, B:57:0x0146, B:58:0x0157, B:59:0x0168, B:60:0x0179, B:61:0x018a, B:62:0x019b, B:63:0x01ac, B:64:0x01bd, B:65:0x01ce, B:66:0x01df, B:67:0x01f0, B:68:0x0201, B:69:0x0212, B:70:0x0223, B:71:0x0234, B:72:0x0245, B:73:0x0256, B:74:0x0267, B:75:0x0278, B:76:0x0289, B:77:0x029a, B:78:0x02ab, B:79:0x02bc, B:80:0x02cd, B:81:0x02de, B:82:0x02ef, B:83:0x02ff, B:84:0x030f, B:85:0x031f, B:86:0x032f), top: B:95:0x000f, outer: #1 }] */
    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Unknown Source)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:390)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:23)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:370)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:85)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:33)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final org.jf.smali.smaliTreeWalker.instruction_return instruction() throws org.antlr.runtime.RecognitionException {
        /*
            Method dump skipped, instruction units count: 1038
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.p088jf.smali.smaliTreeWalker.instruction():org.jf.smali.smaliTreeWalker$instruction_return");
    }

    public final int integer_literal() throws RecognitionException {
        try {
            CommonTree commonTree = (CommonTree) match(this.input, 95, FOLLOW_INTEGER_LITERAL_in_integer_literal3788);
            return LiteralTools.parseInt(commonTree != null ? commonTree.getText() : null);
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
            return 0;
        }
    }

    public final int integral_literal() throws RecognitionException {
        char c;
        int iInteger_literal;
        try {
            int iMo3787LA = this.input.mo3787LA(1);
            if (iMo3787LA == 12) {
                c = 4;
            } else if (iMo3787LA == 95) {
                c = 2;
            } else if (iMo3787LA == 189) {
                c = 1;
            } else {
                if (iMo3787LA != 207) {
                    throw new NoViableAltException("", 45, 0, this.input);
                }
                c = 3;
            }
            if (c == 1) {
                pushFollow(FOLLOW_long_literal_in_integral_literal3744);
                long jLong_literal = long_literal();
                this.state._fsp--;
                LiteralTools.checkInt(jLong_literal);
                return (int) jLong_literal;
            }
            if (c == 2) {
                pushFollow(FOLLOW_integer_literal_in_integral_literal3756);
                iInteger_literal = integer_literal();
                this.state._fsp--;
            } else if (c == 3) {
                pushFollow(FOLLOW_short_literal_in_integral_literal3764);
                iInteger_literal = short_literal();
                this.state._fsp--;
            } else {
                if (c != 4) {
                    return 0;
                }
                pushFollow(FOLLOW_byte_literal_in_integral_literal3772);
                iInteger_literal = byte_literal();
                this.state._fsp--;
            }
            return iInteger_literal;
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
            return 0;
        }
    }

    public final void label_def() throws RecognitionException {
        try {
            match(this.input, 122, FOLLOW_I_LABEL_in_label_def1512);
            match(this.input, 2, null);
            CommonTree commonTree = (CommonTree) match(this.input, 208, FOLLOW_SIMPLE_NAME_in_label_def1514);
            match(this.input, 3, null);
            this.method_stack.peek().methodBuilder.addLabel(commonTree != null ? commonTree.getText() : null);
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
        }
    }

    public final Label label_ref() throws RecognitionException {
        try {
            CommonTree commonTree = (CommonTree) match(this.input, 208, FOLLOW_SIMPLE_NAME_in_label_ref1914);
            return this.method_stack.peek().methodBuilder.getLabel(commonTree != null ? commonTree.getText() : null);
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
            return null;
        }
    }

    public final void line() throws RecognitionException {
        try {
            match(this.input, 123, FOLLOW_I_LINE_in_line1707);
            match(this.input, 2, null);
            pushFollow(FOLLOW_integral_literal_in_line1709);
            int iIntegral_literal = integral_literal();
            RecognizerSharedState recognizerSharedState = this.state;
            recognizerSharedState._fsp--;
            match(this.input, 3, null);
            this.method_stack.peek().methodBuilder.addLineNumber(iIntegral_literal);
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final org.p088jf.dexlib2.immutable.value.ImmutableEncodedValue literal() throws org.antlr.runtime.RecognitionException {
        /*
            Method dump skipped, instruction units count: 620
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.p088jf.smali.smaliTreeWalker.literal():org.jf.dexlib2.immutable.value.ImmutableEncodedValue");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007b A[Catch: all -> 0x00eb, RecognitionException -> 0x00ed, TryCatch #0 {RecognitionException -> 0x00ed, blocks: (B:2:0x0000, B:39:0x00a8, B:41:0x00b0, B:43:0x00b6, B:45:0x00ce, B:46:0x00d0, B:10:0x0036, B:21:0x0061, B:33:0x008b, B:38:0x0098, B:32:0x007b, B:18:0x0048, B:19:0x0059, B:47:0x00de, B:48:0x00ea), top: B:55:0x0000, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0098 A[Catch: all -> 0x00eb, RecognitionException -> 0x00ed, TryCatch #0 {RecognitionException -> 0x00ed, blocks: (B:2:0x0000, B:39:0x00a8, B:41:0x00b0, B:43:0x00b6, B:45:0x00ce, B:46:0x00d0, B:10:0x0036, B:21:0x0061, B:33:0x008b, B:38:0x0098, B:32:0x007b, B:18:0x0048, B:19:0x0059, B:47:0x00de, B:48:0x00ea), top: B:55:0x0000, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void local() throws org.antlr.runtime.RecognitionException {
        /*
            Method dump skipped, instruction units count: 248
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.p088jf.smali.smaliTreeWalker.local():void");
    }

    public final long long_literal() throws RecognitionException {
        try {
            CommonTree commonTree = (CommonTree) match(this.input, 189, FOLLOW_LONG_LITERAL_in_long_literal3803);
            return LiteralTools.parseLong(commonTree != null ? commonTree.getText() : null);
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
            return 0L;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0287 A[Catch: all -> 0x02c5, RecognitionException -> 0x02c7, TryCatch #1 {RecognitionException -> 0x02c7, blocks: (B:3:0x002a, B:5:0x005f, B:8:0x0066, B:10:0x006b, B:12:0x0085, B:14:0x0089, B:41:0x0128, B:43:0x014d, B:45:0x0151, B:53:0x018b, B:58:0x01a8, B:59:0x01b3, B:64:0x01bd, B:68:0x01c7, B:71:0x01cc, B:72:0x01dd, B:73:0x01de, B:75:0x01e4, B:77:0x01ea, B:78:0x01f3, B:79:0x01f4, B:81:0x01fe, B:102:0x0281, B:104:0x0287, B:107:0x028d, B:110:0x0293, B:112:0x0298, B:84:0x020b, B:85:0x0218, B:86:0x0219, B:87:0x0226, B:91:0x022d, B:94:0x0235, B:96:0x024b, B:98:0x0251, B:100:0x0257, B:101:0x0280, B:113:0x02a1, B:114:0x02ac, B:115:0x02ad, B:116:0x02b8, B:117:0x02b9, B:118:0x02c4, B:49:0x017d, B:28:0x00c0, B:30:0x00d1, B:32:0x00e3, B:34:0x00e7, B:40:0x010f, B:35:0x00ff, B:37:0x0109, B:39:0x010d, B:22:0x00ae, B:23:0x00b9), top: B:128:0x002a, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x028d A[Catch: all -> 0x02c5, RecognitionException -> 0x02c7, TryCatch #1 {RecognitionException -> 0x02c7, blocks: (B:3:0x002a, B:5:0x005f, B:8:0x0066, B:10:0x006b, B:12:0x0085, B:14:0x0089, B:41:0x0128, B:43:0x014d, B:45:0x0151, B:53:0x018b, B:58:0x01a8, B:59:0x01b3, B:64:0x01bd, B:68:0x01c7, B:71:0x01cc, B:72:0x01dd, B:73:0x01de, B:75:0x01e4, B:77:0x01ea, B:78:0x01f3, B:79:0x01f4, B:81:0x01fe, B:102:0x0281, B:104:0x0287, B:107:0x028d, B:110:0x0293, B:112:0x0298, B:84:0x020b, B:85:0x0218, B:86:0x0219, B:87:0x0226, B:91:0x022d, B:94:0x0235, B:96:0x024b, B:98:0x0251, B:100:0x0257, B:101:0x0280, B:113:0x02a1, B:114:0x02ac, B:115:0x02ad, B:116:0x02b8, B:117:0x02b9, B:118:0x02c4, B:49:0x017d, B:28:0x00c0, B:30:0x00d1, B:32:0x00e3, B:34:0x00e7, B:40:0x010f, B:35:0x00ff, B:37:0x0109, B:39:0x010d, B:22:0x00ae, B:23:0x00b9), top: B:128:0x002a, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0293 A[Catch: all -> 0x02c5, RecognitionException -> 0x02c7, TryCatch #1 {RecognitionException -> 0x02c7, blocks: (B:3:0x002a, B:5:0x005f, B:8:0x0066, B:10:0x006b, B:12:0x0085, B:14:0x0089, B:41:0x0128, B:43:0x014d, B:45:0x0151, B:53:0x018b, B:58:0x01a8, B:59:0x01b3, B:64:0x01bd, B:68:0x01c7, B:71:0x01cc, B:72:0x01dd, B:73:0x01de, B:75:0x01e4, B:77:0x01ea, B:78:0x01f3, B:79:0x01f4, B:81:0x01fe, B:102:0x0281, B:104:0x0287, B:107:0x028d, B:110:0x0293, B:112:0x0298, B:84:0x020b, B:85:0x0218, B:86:0x0219, B:87:0x0226, B:91:0x022d, B:94:0x0235, B:96:0x024b, B:98:0x0251, B:100:0x0257, B:101:0x0280, B:113:0x02a1, B:114:0x02ac, B:115:0x02ad, B:116:0x02b8, B:117:0x02b9, B:118:0x02c4, B:49:0x017d, B:28:0x00c0, B:30:0x00d1, B:32:0x00e3, B:34:0x00e7, B:40:0x010f, B:35:0x00ff, B:37:0x0109, B:39:0x010d, B:22:0x00ae, B:23:0x00b9), top: B:128:0x002a, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0227  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final org.p088jf.dexlib2.writer.builder.BuilderMethod method() throws org.antlr.runtime.RecognitionException {
        /*
            Method dump skipped, instruction units count: 734
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.p088jf.smali.smaliTreeWalker.method():org.jf.dexlib2.writer.builder.BuilderMethod");
    }

    public final ImmutableMethodHandleReference method_handle_literal() throws RecognitionException {
        try {
            match(this.input, C0299R.styleable.AppCompatTheme_spinnerStyle, FOLLOW_I_ENCODED_METHOD_HANDLE_in_method_handle_literal1391);
            match(this.input, 2, null);
            pushFollow(FOLLOW_method_handle_reference_in_method_handle_literal1393);
            ImmutableMethodHandleReference immutableMethodHandleReferenceMethod_handle_reference = method_handle_reference();
            RecognizerSharedState recognizerSharedState = this.state;
            recognizerSharedState._fsp--;
            match(this.input, 3, null);
            return immutableMethodHandleReferenceMethod_handle_reference;
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
            return null;
        }
    }

    public final ImmutableMethodHandleReference method_handle_reference() throws RecognitionException {
        int iMark;
        char c;
        field_reference_return field_reference_returnVarField_reference;
        ImmutableReference immutableReference;
        try {
            pushFollow(FOLLOW_method_handle_type_in_method_handle_reference1367);
            method_handle_type_return method_handle_type_returnVarMethod_handle_type = method_handle_type();
            this.state._fsp--;
            int iMo3787LA = this.input.mo3787LA(1);
            if (iMo3787LA == 8) {
                int iMo3787LA2 = this.input.mo3787LA(2);
                if (iMo3787LA2 == 202) {
                    if (this.input.mo3787LA(3) == 208) {
                        int iMo3787LA3 = this.input.mo3787LA(4);
                        if (iMo3787LA3 != 8 && iMo3787LA3 != 16 && iMo3787LA3 != 202) {
                            if (iMo3787LA3 == 128) {
                                c = 2;
                            } else {
                                iMark = this.input.mark();
                                while (i < 3) {
                                    try {
                                        this.input.consume();
                                        i++;
                                    } finally {
                                    }
                                }
                                throw new NoViableAltException("", 19, 3, this.input);
                            }
                        }
                        c = 1;
                    } else {
                        iMark = this.input.mark();
                        while (i < 2) {
                            try {
                                this.input.consume();
                                i++;
                            } finally {
                            }
                        }
                        throw new NoViableAltException("", 19, 4, this.input);
                    }
                } else {
                    if (iMo3787LA2 != 16) {
                        iMark = this.input.mark();
                        try {
                            this.input.consume();
                            throw new NoViableAltException("", 19, 2, this.input);
                        } finally {
                        }
                    }
                    if (this.input.mo3787LA(3) == 208) {
                        int iMo3787LA4 = this.input.mo3787LA(4);
                        if (iMo3787LA4 != 8 && iMo3787LA4 != 16 && iMo3787LA4 != 202) {
                            if (iMo3787LA4 == 128) {
                                c = 2;
                            } else {
                                iMark = this.input.mark();
                                while (i < 3) {
                                    try {
                                        this.input.consume();
                                        i++;
                                    } finally {
                                    }
                                }
                                throw new NoViableAltException("", 19, 3, this.input);
                            }
                        }
                        c = 1;
                    } else {
                        iMark = this.input.mark();
                        while (i < 2) {
                            try {
                                this.input.consume();
                                i++;
                            } finally {
                            }
                        }
                        throw new NoViableAltException("", 19, 5, this.input);
                    }
                }
            } else if (iMo3787LA != 16) {
                if (iMo3787LA != 208) {
                    throw new NoViableAltException("", 19, 0, this.input);
                }
                int iMo3787LA5 = this.input.mo3787LA(2);
                if (iMo3787LA5 != 8 && iMo3787LA5 != 16 && iMo3787LA5 != 202) {
                    if (iMo3787LA5 != 128) {
                        iMark = this.input.mark();
                        try {
                            this.input.consume();
                            throw new NoViableAltException("", 19, 3, this.input);
                        } finally {
                        }
                    }
                    c = 2;
                }
                c = 1;
            } else {
                if (this.input.mo3787LA(2) != 208) {
                    iMark = this.input.mark();
                    try {
                        this.input.consume();
                        throw new NoViableAltException("", 19, 1, this.input);
                    } finally {
                    }
                }
                int iMo3787LA6 = this.input.mo3787LA(3);
                if (iMo3787LA6 != 8 && iMo3787LA6 != 16 && iMo3787LA6 != 202) {
                    if (iMo3787LA6 == 128) {
                        c = 2;
                    } else {
                        iMark = this.input.mark();
                        while (i < 2) {
                            try {
                                this.input.consume();
                                i++;
                            } finally {
                            }
                        }
                        throw new NoViableAltException("", 19, 3, this.input);
                    }
                }
                c = 1;
            }
            if (c == 1) {
                pushFollow(FOLLOW_field_reference_in_method_handle_reference1370);
                field_reference_returnVarField_reference = field_reference();
                this.state._fsp--;
                immutableReference = null;
            } else if (c != 2) {
                field_reference_returnVarField_reference = null;
                immutableReference = null;
            } else {
                pushFollow(FOLLOW_method_reference_in_method_handle_reference1374);
                ImmutableMethodReference immutableMethodReferenceMethod_reference = method_reference();
                this.state._fsp--;
                immutableReference = immutableMethodReferenceMethod_reference;
                field_reference_returnVarField_reference = null;
            }
            if ((field_reference_returnVarField_reference != null ? this.input.getTokenStream().toString(this.input.getTreeAdaptor().getTokenStartIndex(field_reference_returnVarField_reference.start), this.input.getTreeAdaptor().getTokenStopIndex(field_reference_returnVarField_reference.start)) : null) != null) {
                immutableReference = field_reference_returnVarField_reference != null ? field_reference_returnVarField_reference.fieldReference : null;
            }
            return new ImmutableMethodHandleReference(method_handle_type_returnVarMethod_handle_type != null ? method_handle_type_returnVarMethod_handle_type.methodHandleType : 0, immutableReference);
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
            return null;
        }
    }

    public final method_handle_type_return method_handle_type() throws RecognitionException {
        method_handle_type_return method_handle_type_returnVar = new method_handle_type_return();
        method_handle_type_returnVar.start = this.input.m3792LT(1);
        try {
            if (this.input.mo3787LA(1) != 82 && (this.input.mo3787LA(1) < 192 || this.input.mo3787LA(1) > 193)) {
                throw new MismatchedSetException(null, this.input);
            }
            this.input.consume();
            this.state.errorRecovery = false;
            method_handle_type_returnVar.methodHandleType = MethodHandleType.getMethodHandleType(this.input.getTokenStream().toString(this.input.getTreeAdaptor().getTokenStartIndex(method_handle_type_returnVar.start), this.input.getTreeAdaptor().getTokenStopIndex(method_handle_type_returnVar.start)));
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
        }
        return method_handle_type_returnVar;
    }

    public final ImmutableMethodReference method_literal() throws RecognitionException {
        try {
            match(this.input, C0299R.styleable.AppCompatTheme_seekBarStyle, FOLLOW_I_ENCODED_METHOD_in_method_literal4133);
            match(this.input, 2, null);
            pushFollow(FOLLOW_method_reference_in_method_literal4135);
            ImmutableMethodReference immutableMethodReferenceMethod_reference = method_reference();
            RecognizerSharedState recognizerSharedState = this.state;
            recognizerSharedState._fsp--;
            match(this.input, 3, null);
            return immutableMethodReferenceMethod_reference;
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
            return null;
        }
    }

    public final method_name_and_prototype_return method_name_and_prototype() throws RecognitionException {
        method_name_and_prototype_return method_name_and_prototype_returnVar = new method_name_and_prototype_return();
        method_name_and_prototype_returnVar.start = this.input.m3792LT(1);
        try {
            CommonTree commonTree = (CommonTree) match(this.input, 208, FOLLOW_SIMPLE_NAME_in_method_name_and_prototype1233);
            pushFollow(FOLLOW_method_prototype_in_method_name_and_prototype1235);
            ImmutableMethodProtoReference immutableMethodProtoReferenceMethod_prototype = method_prototype();
            this.state._fsp--;
            method_name_and_prototype_returnVar.name = commonTree != null ? commonTree.getText() : null;
            method_name_and_prototype_returnVar.parameters = Lists.newArrayList();
            int i = 0;
            for (CharSequence charSequence : immutableMethodProtoReferenceMethod_prototype.getParameterTypes()) {
                int i2 = i + 1;
                method_name_and_prototype_returnVar.parameters.add(new SmaliMethodParameter(i, charSequence.toString()));
                char cCharAt = charSequence.charAt(0);
                if (cCharAt == 'D' || cCharAt == 'J') {
                    i2++;
                }
                i = i2;
            }
            method_name_and_prototype_returnVar.returnType = immutableMethodProtoReferenceMethod_prototype.getReturnType();
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
        }
        return method_name_and_prototype_returnVar;
    }

    public final ImmutableMethodProtoReference method_prototype() throws RecognitionException {
        try {
            match(this.input, 128, FOLLOW_I_METHOD_PROTOTYPE_in_method_prototype1207);
            match(this.input, 2, null);
            match(this.input, 129, FOLLOW_I_METHOD_RETURN_TYPE_in_method_prototype1210);
            match(this.input, 2, null);
            pushFollow(FOLLOW_type_descriptor_in_method_prototype1212);
            String strType_descriptor = type_descriptor();
            RecognizerSharedState recognizerSharedState = this.state;
            recognizerSharedState._fsp--;
            match(this.input, 3, null);
            pushFollow(FOLLOW_method_type_list_in_method_prototype1215);
            List<String> listMethod_type_list = method_type_list();
            RecognizerSharedState recognizerSharedState2 = this.state;
            recognizerSharedState2._fsp--;
            match(this.input, 3, null);
            return new ImmutableMethodProtoReference(listMethod_type_list, strType_descriptor);
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
            return null;
        }
    }

    public final ImmutableMethodReference method_reference() throws RecognitionException {
        reference_type_descriptor_return reference_type_descriptor_returnVarReference_type_descriptor;
        try {
            int iMo3787LA = this.input.mo3787LA(1);
            if (((iMo3787LA == 8 || iMo3787LA == 16) ? (char) 1 : (char) 2) != 1) {
                reference_type_descriptor_returnVarReference_type_descriptor = null;
            } else {
                pushFollow(FOLLOW_reference_type_descriptor_in_method_reference1409);
                reference_type_descriptor_returnVarReference_type_descriptor = reference_type_descriptor();
                this.state._fsp--;
            }
            CommonTree commonTree = (CommonTree) match(this.input, 208, FOLLOW_SIMPLE_NAME_in_method_reference1412);
            pushFollow(FOLLOW_method_prototype_in_method_reference1414);
            ImmutableMethodProtoReference immutableMethodProtoReferenceMethod_prototype = method_prototype();
            this.state._fsp--;
            return new ImmutableMethodReference((reference_type_descriptor_returnVarReference_type_descriptor != null ? reference_type_descriptor_returnVarReference_type_descriptor.type : null) == null ? this.classType : reference_type_descriptor_returnVarReference_type_descriptor != null ? reference_type_descriptor_returnVarReference_type_descriptor.type : null, commonTree != null ? commonTree.getText() : null, immutableMethodProtoReferenceMethod_prototype.getParameterTypes(), immutableMethodProtoReferenceMethod_prototype.getReturnType());
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
            return null;
        }
    }

    public final List<String> method_type_list() throws RecognitionException {
        ArrayList arrayListNewArrayList = Lists.newArrayList();
        while (true) {
            try {
                int iMo3787LA = this.input.mo3787LA(1);
                if (((iMo3787LA == 8 || iMo3787LA == 16 || iMo3787LA == 202) ? (char) 1 : (char) 2) != 1) {
                    break;
                }
                pushFollow(FOLLOW_nonvoid_type_descriptor_in_method_type_list1269);
                nonvoid_type_descriptor_return nonvoid_type_descriptor_returnVarNonvoid_type_descriptor = nonvoid_type_descriptor();
                this.state._fsp--;
                arrayListNewArrayList.add(nonvoid_type_descriptor_returnVarNonvoid_type_descriptor != null ? nonvoid_type_descriptor_returnVarNonvoid_type_descriptor.type : null);
            } catch (RecognitionException e) {
                reportError(e);
                recover(this.input, e);
            }
        }
        return arrayListNewArrayList;
    }

    public final List<BuilderMethod> methods() throws RecognitionException {
        ArrayList arrayListNewArrayList = Lists.newArrayList();
        try {
            match(this.input, 127, FOLLOW_I_METHODS_in_methods446);
            if (this.input.mo3787LA(1) == 2) {
                match(this.input, 2, null);
                while (true) {
                    if ((this.input.mo3787LA(1) == 126 ? (char) 1 : (char) 2) != 1) {
                        break;
                    }
                    pushFollow(FOLLOW_method_in_methods455);
                    BuilderMethod builderMethodMethod = method();
                    this.state._fsp--;
                    arrayListNewArrayList.add(builderMethodMethod);
                }
                match(this.input, 3, null);
            }
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
        }
        return arrayListNewArrayList;
    }

    public final nonvoid_type_descriptor_return nonvoid_type_descriptor() throws RecognitionException {
        char c;
        nonvoid_type_descriptor_return nonvoid_type_descriptor_returnVar = new nonvoid_type_descriptor_return();
        nonvoid_type_descriptor_returnVar.start = this.input.m3792LT(1);
        try {
            int iMo3787LA = this.input.mo3787LA(1);
            if (iMo3787LA == 8) {
                c = 3;
            } else if (iMo3787LA == 16) {
                c = 2;
            } else {
                if (iMo3787LA != 202) {
                    throw new NoViableAltException("", 41, 0, this.input);
                }
                c = 1;
            }
            if (c == 1) {
                match(this.input, 202, FOLLOW_PRIMITIVE_TYPE_in_nonvoid_type_descriptor3598);
                nonvoid_type_descriptor_returnVar.type = this.input.getTokenStream().toString(this.input.getTreeAdaptor().getTokenStartIndex(nonvoid_type_descriptor_returnVar.start), this.input.getTreeAdaptor().getTokenStopIndex(nonvoid_type_descriptor_returnVar.start));
            } else if (c == 2) {
                match(this.input, 16, FOLLOW_CLASS_DESCRIPTOR_in_nonvoid_type_descriptor3606);
                nonvoid_type_descriptor_returnVar.type = this.input.getTokenStream().toString(this.input.getTreeAdaptor().getTokenStartIndex(nonvoid_type_descriptor_returnVar.start), this.input.getTreeAdaptor().getTokenStopIndex(nonvoid_type_descriptor_returnVar.start));
            } else if (c == 3) {
                pushFollow(FOLLOW_array_descriptor_in_nonvoid_type_descriptor3614);
                String strArray_descriptor = array_descriptor();
                this.state._fsp--;
                nonvoid_type_descriptor_returnVar.type = strArray_descriptor;
            }
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
        }
        return nonvoid_type_descriptor_returnVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x006d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0043 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void ordered_method_items() throws org.antlr.runtime.RecognitionException {
        /*
            Method dump skipped, instruction units count: 234
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.p088jf.smali.smaliTreeWalker.ordered_method_items():void");
    }

    public final List<Label> packed_switch_elements() throws RecognitionException {
        ArrayList arrayListNewArrayList = Lists.newArrayList();
        try {
            match(this.input, 131, FOLLOW_I_PACKED_SWITCH_ELEMENTS_in_packed_switch_elements950);
            if (this.input.mo3787LA(1) == 2) {
                match(this.input, 2, null);
                while (true) {
                    if ((this.input.mo3787LA(1) == 208 ? (char) 1 : (char) 2) != 1) {
                        break;
                    }
                    pushFollow(FOLLOW_label_ref_in_packed_switch_elements959);
                    Label labelLabel_ref = label_ref();
                    this.state._fsp--;
                    arrayListNewArrayList.add(labelLabel_ref);
                }
                match(this.input, 3, null);
            }
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
        }
        return arrayListNewArrayList;
    }

    public final void parameter(List<SmaliMethodParameter> list) throws RecognitionException {
        String strString_literal;
        try {
            CommonTree commonTree = (CommonTree) match(this.input, 133, FOLLOW_I_PARAMETER_in_parameter1636);
            match(this.input, 2, null);
            CommonTree commonTree2 = (CommonTree) match(this.input, 204, FOLLOW_REGISTER_in_parameter1638);
            if ((this.input.mo3787LA(1) == 211 ? (char) 1 : (char) 2) != 1) {
                strString_literal = null;
            } else {
                pushFollow(FOLLOW_string_literal_in_parameter1640);
                strString_literal = string_literal();
                this.state._fsp--;
            }
            pushFollow(FOLLOW_annotations_in_parameter1643);
            Set<Annotation> setAnnotations = annotations();
            this.state._fsp--;
            match(this.input, 3, null);
            int register_short = parseRegister_short(commonTree2 != null ? commonTree2.getText() : null);
            int i = this.method_stack.peek().totalMethodRegisters;
            int i2 = this.method_stack.peek().methodParameterRegisters;
            if (register_short >= i) {
                TreeNodeStream treeNodeStream = this.input;
                Object[] objArr = new Object[2];
                objArr[0] = commonTree2 != null ? commonTree2.getText() : null;
                objArr[1] = Integer.valueOf(i - 1);
                throw new SemanticException(treeNodeStream, commonTree, "Register %s is larger than the maximum register v%d for this method", objArr);
            }
            final int i3 = (register_short - (i - i2)) - (!this.method_stack.peek().isStatic ? 1 : 0);
            if (i3 < 0) {
                TreeNodeStream treeNodeStream2 = this.input;
                Object[] objArr2 = new Object[1];
                objArr2[0] = commonTree2 != null ? commonTree2.getText() : null;
                throw new SemanticException(treeNodeStream2, commonTree, "Register %s is not a parameter register.", objArr2);
            }
            int iLinearSearch = LinearSearch.linearSearch(list, SmaliMethodParameter.COMPARATOR, new WithRegister(this) { // from class: org.jf.smali.smaliTreeWalker.1
                @Override // org.p088jf.smali.WithRegister
                public int getRegister() {
                    return i3;
                }
            }, i3);
            if (iLinearSearch < 0) {
                TreeNodeStream treeNodeStream3 = this.input;
                Object[] objArr3 = new Object[1];
                objArr3[0] = commonTree2 != null ? commonTree2.getText() : null;
                throw new SemanticException(treeNodeStream3, commonTree, "Register %s is the second half of a wide parameter.", objArr3);
            }
            SmaliMethodParameter smaliMethodParameter = list.get(iLinearSearch);
            smaliMethodParameter.name = strString_literal;
            if (setAnnotations == null || setAnnotations.size() <= 0) {
                return;
            }
            smaliMethodParameter.annotations = setAnnotations;
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
        }
    }

    public final void parameters(List<SmaliMethodParameter> list) throws RecognitionException {
        try {
            match(this.input, 134, FOLLOW_I_PARAMETERS_in_parameters1617);
            if (this.input.mo3787LA(1) != 2) {
                return;
            }
            match(this.input, 2, null);
            while (true) {
                if ((this.input.mo3787LA(1) == 133 ? (char) 1 : (char) 2) != 1) {
                    match(this.input, 3, null);
                    return;
                }
                pushFollow(FOLLOW_parameter_in_parameters1620);
                parameter(list);
                this.state._fsp--;
            }
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
        }
    }

    public final short parseRegister_byte(String str) throws SemanticException {
        int i = this.method_stack.peek().totalMethodRegisters;
        int i2 = this.method_stack.peek().methodParameterRegisters;
        int i3 = Short.parseShort(str.substring(1));
        if (str.charAt(0) == 'p') {
            i3 += i - i2;
        }
        if (i3 < 512) {
            return (short) i3;
        }
        throw new SemanticException(this.input, "The maximum allowed register in this context is v255", new Object[0]);
    }

    public final byte parseRegister_nibble(String str) throws SemanticException {
        int i = this.method_stack.peek().totalMethodRegisters;
        int i2 = this.method_stack.peek().methodParameterRegisters;
        int i3 = Byte.parseByte(str.substring(1));
        if (str.charAt(0) == 'p') {
            i3 += i - i2;
        }
        if (i3 < 32) {
            return (byte) i3;
        }
        throw new SemanticException(this.input, "The maximum allowed register in this context is list of registers is v15", new Object[0]);
    }

    public final int parseRegister_short(String str) throws SemanticException {
        int i = this.method_stack.peek().totalMethodRegisters;
        int i2 = this.method_stack.peek().methodParameterRegisters;
        int i3 = Integer.parseInt(str.substring(1));
        if (str.charAt(0) == 'p') {
            i3 += i - i2;
        }
        if (i3 < 131072) {
            return i3;
        }
        throw new SemanticException(this.input, "The maximum allowed register in this context is v65535", new Object[0]);
    }

    public final void prologue() throws RecognitionException {
        try {
            match(this.input, 136, FOLLOW_I_PROLOGUE_in_prologue1807);
            this.method_stack.peek().methodBuilder.addPrologue();
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
        }
    }

    public final reference_type_descriptor_return reference_type_descriptor() throws RecognitionException {
        char c;
        reference_type_descriptor_return reference_type_descriptor_returnVar = new reference_type_descriptor_return();
        reference_type_descriptor_returnVar.start = this.input.m3792LT(1);
        try {
            int iMo3787LA = this.input.mo3787LA(1);
            if (iMo3787LA == 16) {
                c = 1;
            } else {
                if (iMo3787LA != 8) {
                    throw new NoViableAltException("", 42, 0, this.input);
                }
                c = 2;
            }
            if (c == 1) {
                match(this.input, 16, FOLLOW_CLASS_DESCRIPTOR_in_reference_type_descriptor3635);
                reference_type_descriptor_returnVar.type = this.input.getTokenStream().toString(this.input.getTreeAdaptor().getTokenStartIndex(reference_type_descriptor_returnVar.start), this.input.getTreeAdaptor().getTokenStopIndex(reference_type_descriptor_returnVar.start));
            } else if (c == 2) {
                pushFollow(FOLLOW_array_descriptor_in_reference_type_descriptor3643);
                String strArray_descriptor = array_descriptor();
                this.state._fsp--;
                reference_type_descriptor_returnVar.type = strArray_descriptor;
            }
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
        }
        return reference_type_descriptor_returnVar;
    }

    public final register_list_return register_list() throws RecognitionException {
        register_list_return register_list_returnVar = new register_list_return();
        register_list_returnVar.start = this.input.m3792LT(1);
        register_list_returnVar.registers = new byte[5];
        register_list_returnVar.registerCount = (byte) 0;
        try {
            CommonTree commonTree = (CommonTree) match(this.input, 138, FOLLOW_I_REGISTER_LIST_in_register_list1939);
            if (this.input.mo3787LA(1) == 2) {
                match(this.input, 2, null);
                while (true) {
                    if ((this.input.mo3787LA(1) == 204 ? (char) 1 : (char) 2) != 1) {
                        match(this.input, 3, null);
                        break;
                    }
                    CommonTree commonTree2 = (CommonTree) match(this.input, 204, FOLLOW_REGISTER_in_register_list1948);
                    byte b2 = register_list_returnVar.registerCount;
                    if (b2 == 5) {
                        throw new SemanticException(this.input, commonTree, "A list of registers can only have a maximum of 5 registers. Use the <op>/range alternate opcode instead.", new Object[0]);
                    }
                    byte[] bArr = register_list_returnVar.registers;
                    register_list_returnVar.registerCount = (byte) (b2 + 1);
                    bArr[b2] = parseRegister_nibble(commonTree2 != null ? commonTree2.getText() : null);
                }
            }
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
        }
        return register_list_returnVar;
    }

    public final register_range_return register_range() throws RecognitionException {
        CommonTree commonTree;
        CommonTree commonTree2;
        register_range_return register_range_returnVar = new register_range_return();
        register_range_returnVar.start = this.input.m3792LT(1);
        try {
            CommonTree commonTree3 = (CommonTree) match(this.input, 139, FOLLOW_I_REGISTER_RANGE_in_register_range1973);
            CommonTree commonTree4 = null;
            if (this.input.mo3787LA(1) == 2) {
                match(this.input, 2, null);
                if ((this.input.mo3787LA(1) == 204 ? (char) 1 : (char) 2) != 1) {
                    commonTree2 = null;
                    commonTree = null;
                } else {
                    commonTree2 = (CommonTree) match(this.input, 204, FOLLOW_REGISTER_in_register_range1978);
                    commonTree = (this.input.mo3787LA(1) == 204 ? (char) 1 : (char) 2) != 1 ? null : (CommonTree) match(this.input, 204, FOLLOW_REGISTER_in_register_range1982);
                }
                match(this.input, 3, null);
                commonTree4 = commonTree2;
            } else {
                commonTree = null;
            }
            if (commonTree4 == null) {
                register_range_returnVar.startRegister = 0;
                register_range_returnVar.endRegister = -1;
            } else {
                int register_short = parseRegister_short(commonTree4.getText());
                register_range_returnVar.startRegister = register_short;
                if (commonTree == null) {
                    register_range_returnVar.endRegister = register_short;
                } else {
                    register_range_returnVar.endRegister = parseRegister_short(commonTree.getText());
                }
                if ((register_range_returnVar.endRegister - register_range_returnVar.startRegister) + 1 < 1) {
                    throw new SemanticException(this.input, commonTree3, "A register range must have the lower register listed first", new Object[0]);
                }
            }
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
        }
        return register_range_returnVar;
    }

    public final registers_directive_return registers_directive() throws RecognitionException {
        char c;
        registers_directive_return registers_directive_returnVar = new registers_directive_return();
        registers_directive_returnVar.start = this.input.m3792LT(1);
        try {
            registers_directive_returnVar.registers = 0;
            int iMo3787LA = this.input.mo3787LA(1);
            if (iMo3787LA == 137) {
                c = 1;
            } else {
                if (iMo3787LA != 125) {
                    throw new NoViableAltException("", 22, 0, this.input);
                }
                c = 2;
            }
            if (c == 1) {
                match(this.input, 137, FOLLOW_I_REGISTERS_in_registers_directive1462);
                registers_directive_returnVar.isLocalsDirective = false;
            } else if (c == 2) {
                match(this.input, 125, FOLLOW_I_LOCALS_in_registers_directive1474);
                registers_directive_returnVar.isLocalsDirective = true;
            }
            match(this.input, 2, null);
            pushFollow(FOLLOW_short_integral_literal_in_registers_directive1492);
            short sShort_integral_literal = short_integral_literal();
            this.state._fsp--;
            registers_directive_returnVar.registers = sShort_integral_literal & 65535;
            match(this.input, 3, null);
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
        }
        return registers_directive_returnVar;
    }

    public final void restart_local() throws RecognitionException {
        try {
            match(this.input, 140, FOLLOW_I_RESTART_LOCAL_in_restart_local1788);
            match(this.input, 2, null);
            CommonTree commonTree = (CommonTree) match(this.input, 204, FOLLOW_REGISTER_in_restart_local1790);
            match(this.input, 3, null);
            this.method_stack.peek().methodBuilder.addRestartLocal(parseRegister_short(commonTree != null ? commonTree.getText() : null));
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
        }
    }

    public void setApiLevel(int i) {
        this.opcodes = Opcodes.forApi(i);
        this.apiLevel = i;
    }

    public void setDexBuilder(DexBuilder dexBuilder) {
        this.dexBuilder = dexBuilder;
    }

    public void setVerboseErrors(boolean z) {
        this.verboseErrors = z;
    }

    public final short short_integral_literal() throws RecognitionException {
        char c;
        int iInteger_literal;
        try {
            int iMo3787LA = this.input.mo3787LA(1);
            if (iMo3787LA == 12) {
                c = 5;
            } else if (iMo3787LA == 15) {
                c = 4;
            } else if (iMo3787LA == 95) {
                c = 2;
            } else if (iMo3787LA == 189) {
                c = 1;
            } else {
                if (iMo3787LA != 207) {
                    throw new NoViableAltException("", 44, 0, this.input);
                }
                c = 3;
            }
            if (c == 1) {
                pushFollow(FOLLOW_long_literal_in_short_integral_literal3689);
                long jLong_literal = long_literal();
                this.state._fsp--;
                LiteralTools.checkShort(jLong_literal);
                return (short) jLong_literal;
            }
            if (c == 2) {
                pushFollow(FOLLOW_integer_literal_in_short_integral_literal3701);
                iInteger_literal = integer_literal();
                this.state._fsp--;
                LiteralTools.checkShort(iInteger_literal);
            } else {
                if (c == 3) {
                    pushFollow(FOLLOW_short_literal_in_short_integral_literal3713);
                    short sShort_literal = short_literal();
                    this.state._fsp--;
                    return sShort_literal;
                }
                if (c == 4) {
                    pushFollow(FOLLOW_char_literal_in_short_integral_literal3721);
                    iInteger_literal = char_literal();
                    this.state._fsp--;
                } else {
                    if (c != 5) {
                        return (short) 0;
                    }
                    pushFollow(FOLLOW_byte_literal_in_short_integral_literal3729);
                    iInteger_literal = byte_literal();
                    this.state._fsp--;
                }
            }
            return (short) iInteger_literal;
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
            return (short) 0;
        }
    }

    public final short short_literal() throws RecognitionException {
        try {
            CommonTree commonTree = (CommonTree) match(this.input, 207, FOLLOW_SHORT_LITERAL_in_short_literal3818);
            return LiteralTools.parseShort(commonTree != null ? commonTree.getText() : null);
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
            return (short) 0;
        }
    }

    public final ClassDef smali_file() throws RecognitionException {
        try {
            match(this.input, 109, FOLLOW_I_CLASS_DEF_in_smali_file52);
            match(this.input, 2, null);
            pushFollow(FOLLOW_header_in_smali_file54);
            header_return header_returnVarHeader = header();
            RecognizerSharedState recognizerSharedState = this.state;
            recognizerSharedState._fsp--;
            pushFollow(FOLLOW_methods_in_smali_file56);
            List<BuilderMethod> listMethods = methods();
            RecognizerSharedState recognizerSharedState2 = this.state;
            recognizerSharedState2._fsp--;
            pushFollow(FOLLOW_fields_in_smali_file58);
            List<BuilderField> listFields = fields();
            RecognizerSharedState recognizerSharedState3 = this.state;
            recognizerSharedState3._fsp--;
            pushFollow(FOLLOW_annotations_in_smali_file60);
            Set<Annotation> setAnnotations = annotations();
            RecognizerSharedState recognizerSharedState4 = this.state;
            recognizerSharedState4._fsp--;
            match(this.input, 3, null);
            return this.dexBuilder.internClassDef(header_returnVarHeader != null ? header_returnVarHeader.classType : null, header_returnVarHeader != null ? header_returnVarHeader.accessFlags : 0, header_returnVarHeader != null ? header_returnVarHeader.superType : null, header_returnVarHeader != null ? header_returnVarHeader.implementsList : null, header_returnVarHeader != null ? header_returnVarHeader.sourceSpec : null, setAnnotations, listFields, listMethods);
        } catch (Exception e) {
            if (this.verboseErrors) {
                e.printStackTrace(System.err);
            }
            reportError(new SemanticException(this.input, e));
            return null;
        }
    }

    public final void source() throws RecognitionException {
        String strString_literal;
        try {
            match(this.input, 141, FOLLOW_I_SOURCE_in_source1840);
            String str = null;
            if (this.input.mo3787LA(1) == 2) {
                match(this.input, 2, null);
                if ((this.input.mo3787LA(1) == 211 ? (char) 1 : (char) 2) != 1) {
                    strString_literal = null;
                } else {
                    pushFollow(FOLLOW_string_literal_in_source1842);
                    strString_literal = string_literal();
                    this.state._fsp--;
                }
                match(this.input, 3, null);
                str = strString_literal;
            }
            this.method_stack.peek().methodBuilder.addSetSourceFile(this.dexBuilder.internNullableStringReference(str));
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
        }
    }

    public final String source_spec() throws RecognitionException {
        String strString_literal;
        RecognitionException e;
        char c;
        try {
            int iMo3787LA = this.input.mo3787LA(1);
            if (iMo3787LA == 141) {
                c = 1;
            } else {
                if (iMo3787LA != 127) {
                    throw new NoViableAltException("", 3, 0, this.input);
                }
                c = 2;
            }
        } catch (RecognitionException e2) {
            strString_literal = null;
            e = e2;
        }
        if (c != 1) {
            return null;
        }
        match(this.input, 141, FOLLOW_I_SOURCE_in_source_spec213);
        match(this.input, 2, null);
        pushFollow(FOLLOW_string_literal_in_source_spec215);
        strString_literal = string_literal();
        this.state._fsp--;
        try {
            match(this.input, 3, null);
        } catch (RecognitionException e3) {
            e = e3;
            reportError(e);
            recover(this.input, e);
        }
        return strString_literal;
    }

    public final List<SwitchLabelElement> sparse_switch_elements() throws RecognitionException {
        ArrayList arrayListNewArrayList = Lists.newArrayList();
        try {
            match(this.input, 142, FOLLOW_I_SPARSE_SWITCH_ELEMENTS_in_sparse_switch_elements994);
            if (this.input.mo3787LA(1) == 2) {
                match(this.input, 2, null);
                while (true) {
                    int iMo3787LA = this.input.mo3787LA(1);
                    if ((((iMo3787LA >= 11 && iMo3787LA <= 12) || iMo3787LA == 15 || iMo3787LA == 39 || iMo3787LA == 95 || iMo3787LA == 189 || iMo3787LA == 207) ? (char) 1 : (char) 2) != 1) {
                        break;
                    }
                    pushFollow(FOLLOW_fixed_32bit_literal_in_sparse_switch_elements1004);
                    int iFixed_32bit_literal = fixed_32bit_literal();
                    this.state._fsp--;
                    pushFollow(FOLLOW_label_ref_in_sparse_switch_elements1006);
                    Label labelLabel_ref = label_ref();
                    this.state._fsp--;
                    arrayListNewArrayList.add(new SwitchLabelElement(iFixed_32bit_literal, labelLabel_ref));
                }
                match(this.input, 3, null);
            }
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
        }
        return arrayListNewArrayList;
    }

    public final String string_literal() throws RecognitionException {
        try {
            CommonTree commonTree = (CommonTree) match(this.input, 211, FOLLOW_STRING_LITERAL_in_string_literal3893);
            String text = commonTree != null ? commonTree.getText() : null;
            return text.substring(1, text.length() - 1);
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
            return null;
        }
    }

    public final subannotation_return subannotation() throws RecognitionException {
        ArrayList arrayListNewArrayList;
        CommonTree commonTree;
        subannotation_return subannotation_returnVar = new subannotation_return();
        subannotation_returnVar.start = this.input.m3792LT(1);
        try {
            arrayListNewArrayList = Lists.newArrayList();
            match(this.input, 183, FOLLOW_I_SUBANNOTATION_in_subannotation4050);
            match(this.input, 2, null);
            commonTree = (CommonTree) match(this.input, 16, FOLLOW_CLASS_DESCRIPTOR_in_subannotation4060);
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
        }
        while (true) {
            if ((this.input.mo3787LA(1) == 101 ? (char) 1 : (char) 2) != 1) {
                break;
            }
            pushFollow(FOLLOW_annotation_element_in_subannotation4071);
            AnnotationElement annotationElementAnnotation_element = annotation_element();
            this.state._fsp--;
            arrayListNewArrayList.add(annotationElementAnnotation_element);
            return subannotation_returnVar;
        }
        match(this.input, 3, null);
        subannotation_returnVar.annotationType = commonTree != null ? commonTree.getText() : null;
        subannotation_returnVar.elements = arrayListNewArrayList;
        return subannotation_returnVar;
    }

    public final String super_spec() throws RecognitionException {
        try {
            match(this.input, 184, FOLLOW_I_SUPER_in_super_spec130);
            match(this.input, 2, null);
            CommonTree commonTree = (CommonTree) match(this.input, 16, FOLLOW_CLASS_DESCRIPTOR_in_super_spec132);
            match(this.input, 3, null);
            if (commonTree != null) {
                return commonTree.getText();
            }
            return null;
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
            return null;
        }
    }

    public final String type_descriptor() throws RecognitionException {
        char c;
        try {
            int iMo3787LA = this.input.mo3787LA(1);
            if (iMo3787LA == 215) {
                c = 1;
            } else {
                if (iMo3787LA != 8 && iMo3787LA != 16 && iMo3787LA != 202) {
                    throw new NoViableAltException("", 43, 0, this.input);
                }
                c = 2;
            }
            if (c == 1) {
                match(this.input, 215, FOLLOW_VOID_TYPE_in_type_descriptor3663);
                return "V";
            }
            if (c != 2) {
                return null;
            }
            pushFollow(FOLLOW_nonvoid_type_descriptor_in_type_descriptor3671);
            nonvoid_type_descriptor_return nonvoid_type_descriptor_returnVarNonvoid_type_descriptor = nonvoid_type_descriptor();
            this.state._fsp--;
            if (nonvoid_type_descriptor_returnVarNonvoid_type_descriptor != null) {
                return nonvoid_type_descriptor_returnVarNonvoid_type_descriptor.type;
            }
            return null;
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
            return null;
        }
    }

    public final ImmutableReference verification_error_reference() throws RecognitionException {
        int iMark;
        char c;
        try {
            int iMo3787LA = this.input.mo3787LA(1);
            int i = 0;
            if (iMo3787LA == 8) {
                int iMo3787LA2 = this.input.mo3787LA(2);
                if (iMo3787LA2 == 202) {
                    if (this.input.mo3787LA(3) == 208) {
                        int iMo3787LA3 = this.input.mo3787LA(4);
                        if (iMo3787LA3 != 8 && iMo3787LA3 != 16 && iMo3787LA3 != 202) {
                            if (iMo3787LA3 == 128) {
                                c = 3;
                            } else {
                                iMark = this.input.mark();
                                while (i < 3) {
                                    try {
                                        this.input.consume();
                                        i++;
                                    } finally {
                                    }
                                }
                                throw new NoViableAltException("", 38, 3, this.input);
                            }
                        }
                        c = 2;
                    } else {
                        iMark = this.input.mark();
                        while (i < 2) {
                            try {
                                this.input.consume();
                                i++;
                            } finally {
                            }
                        }
                        throw new NoViableAltException("", 38, 5, this.input);
                    }
                } else {
                    if (iMo3787LA2 != 16) {
                        iMark = this.input.mark();
                        try {
                            this.input.consume();
                            throw new NoViableAltException("", 38, 2, this.input);
                        } finally {
                        }
                    }
                    if (this.input.mo3787LA(3) == 208) {
                        int iMo3787LA4 = this.input.mo3787LA(4);
                        if (iMo3787LA4 != 8 && iMo3787LA4 != 16 && iMo3787LA4 != 202) {
                            if (iMo3787LA4 == 128) {
                                c = 3;
                            } else {
                                iMark = this.input.mark();
                                while (i < 3) {
                                    try {
                                        this.input.consume();
                                        i++;
                                    } finally {
                                    }
                                }
                                throw new NoViableAltException("", 38, 3, this.input);
                            }
                        }
                        c = 2;
                    } else {
                        iMark = this.input.mark();
                        while (i < 2) {
                            try {
                                this.input.consume();
                                i++;
                            } finally {
                            }
                        }
                        throw new NoViableAltException("", 38, 6, this.input);
                    }
                }
            } else if (iMo3787LA == 16) {
                int iMo3787LA5 = this.input.mo3787LA(2);
                if (iMo3787LA5 == 3) {
                    c = 1;
                } else {
                    if (iMo3787LA5 != 208) {
                        iMark = this.input.mark();
                        try {
                            this.input.consume();
                            throw new NoViableAltException("", 38, 1, this.input);
                        } finally {
                        }
                    }
                    int iMo3787LA6 = this.input.mo3787LA(3);
                    if (iMo3787LA6 != 8 && iMo3787LA6 != 16 && iMo3787LA6 != 202) {
                        if (iMo3787LA6 == 128) {
                            c = 3;
                        } else {
                            iMark = this.input.mark();
                            while (i < 2) {
                                try {
                                    this.input.consume();
                                    i++;
                                } finally {
                                }
                            }
                            throw new NoViableAltException("", 38, 3, this.input);
                        }
                    }
                    c = 2;
                }
            } else {
                if (iMo3787LA != 208) {
                    throw new NoViableAltException("", 38, 0, this.input);
                }
                int iMo3787LA7 = this.input.mo3787LA(2);
                if (iMo3787LA7 != 8 && iMo3787LA7 != 16 && iMo3787LA7 != 202) {
                    if (iMo3787LA7 != 128) {
                        iMark = this.input.mark();
                        try {
                            this.input.consume();
                            throw new NoViableAltException("", 38, 3, this.input);
                        } finally {
                        }
                    }
                    c = 3;
                }
                c = 2;
            }
            if (c == 1) {
                CommonTree commonTree = (CommonTree) match(this.input, 16, FOLLOW_CLASS_DESCRIPTOR_in_verification_error_reference2005);
                return new ImmutableTypeReference(commonTree != null ? commonTree.getText() : null);
            }
            if (c != 2) {
                if (c != 3) {
                    return null;
                }
                pushFollow(FOLLOW_method_reference_in_verification_error_reference2025);
                ImmutableMethodReference immutableMethodReferenceMethod_reference = method_reference();
                this.state._fsp--;
                return immutableMethodReferenceMethod_reference;
            }
            pushFollow(FOLLOW_field_reference_in_verification_error_reference2015);
            field_reference_return field_reference_returnVarField_reference = field_reference();
            this.state._fsp--;
            if (field_reference_returnVarField_reference != null) {
                return field_reference_returnVarField_reference.fieldReference;
            }
            return null;
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
            return null;
        }
    }

    public final int verification_error_type() throws RecognitionException {
        try {
            CommonTree commonTree = (CommonTree) match(this.input, 214, FOLLOW_VERIFICATION_ERROR_TYPE_in_verification_error_type2042);
            return VerificationError.getVerificationError(commonTree != null ? commonTree.getText() : null);
        } catch (RecognitionException e) {
            reportError(e);
            recover(this.input, e);
            return 0;
        }
    }
}
